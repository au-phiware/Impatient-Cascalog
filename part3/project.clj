(defproject impatient "0.1.0-SNAPSHOT"
  :description "Cascalog for the Impatient - Part 3"
  :url "https://github.com/Quantisan/Impatient/tree/cascalog/part3"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :uberjar-name "impatient.jar"
  :aot [impatient.core]
  :main impatient.core
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [cascalog "2.1.1"]
                 [cascalog/cascalog-more-taps "2.1.1"]]
  :profiles {:provided {:dependencies [[org.apache.hadoop/hadoop-core "1.2.1"]]}})
