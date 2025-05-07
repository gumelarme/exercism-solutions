(ns pangram
  (:require [clojure.string :as str]))

(def alphabet
  (set "abcdefghijklmnopqrstuvwxyz"))

(defn pangram?
  "Returns true if the given string is a pangram; otherwise, returns false"
  [text]
  (= alphabet
     (-> text
         (str/lower-case)
         (str/replace #"[^a-z]" "")
         (set))))
