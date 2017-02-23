(ns proxydup.core)
(require '[org.httpkit.server :as server]
         '[org.httpkit.client :as client]
         '[carica.core :as config])

(def proxies (config/config :proxies))

(defn proxy-req! [proxy method body content-type]
  (client/request { :url proxy
                    :method method 
                    :body body
                    :headers {"Content-Type" content-type } }))

(defn app [req]
  (let [m (req :request-method)
        b (->> req :body .bytes)
        c (->> req :content-type name)]
    (doall (map #(proxy-req! % m (->> b aclone java.nio.ByteBuffer/wrap) c) proxies))
    {:status  200
    :headers {"Content-Type" "application/text"}
    :body "OK"}))

(defn -main []
  (server/run-server app {:port 8080}))