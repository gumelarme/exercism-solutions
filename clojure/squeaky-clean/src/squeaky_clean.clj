(ns squeaky-clean
  (:import java.lang.Character)
  (:require [clojure.string :as str]))

(defn clean
  "Clean up string"
  [s]
  (-> s
      (str/replace \space \_)
      (str/replace #"\p{IsControl}" "CTRL")
      (str/replace #"-(\p{Ll})" #(str/upper-case (get %1 1))) ;;camelize
      (str/replace #"[^_\p{L}]" "")
      (str/replace #"[\p{IsGreek}&&\p{IsLowercase}]" "")))
