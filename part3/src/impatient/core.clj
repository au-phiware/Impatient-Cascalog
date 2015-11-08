(ns impatient.core
  (:use [cascalog.api]
        [cascalog.more-taps :only (hfs-delimited)])
  (:require [clojure.string :as s]
             [cascalog.logic.def :as d]
            [cascalog.logic.ops :as c])
  (:gen-class))

(d/defmapcapfn split [line]
  "reads in a line of string and splits it by regex"
  (s/split line #"[\[\]\\\(\),.)\s]+"))

(defn scrub-text [s]
  "trim open whitespaces and lower case"
  ((c/comp s/trim s/lower-case) s))

(defn -main [in out & args]
  (?<- (hfs-delimited out)
       [?word ?count]
       ((hfs-delimited in :skip-header? true) _ ?line)
       (split ?line :> ?word-dirty)
       (scrub-text ?word-dirty :> ?word)
       (c/count ?count)))
