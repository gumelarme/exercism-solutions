(ns log-levels
  (:require [clojure.string :as str]))

(defn parse-log
  [s]
    (let [[level msg] (str/split s #":")]
      {:level (-> level
                (str/replace #"\[|\]", "")
                (str/trim)
                (str/lower-case))
       :message (str/trim msg)}))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  ((parse-log s) :message))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  ((parse-log s) :level))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [parsed (parse-log s)]
    (format "%s (%s)" (message s) (log-level s))))
