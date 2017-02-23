(defproject proxydup "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main proxydup.core
  :resource-paths ["resources"]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [http-kit "2.2.0"]
                 [sonian/carica "1.2.2" :exclusions [[cheshire]]]])
