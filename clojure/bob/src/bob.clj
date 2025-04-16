(ns bob)

(require '[clojure.string :as str])

(defn has-char? [text]
  (boolean (re-find #"[a-zA-Z]" text)))

(defn yelling? [text]
  (and (has-char? text)
       (= (str/upper-case text) text)))

(defn asking? [text]
  (str/ends-with? text "?"))

(defn response-for [text]
  (let [s (str/trim text)
        ask? (asking? s)
        yell? (yelling? s)]

    (cond (empty? s) "Fine. Be that way!"
          (and ask? yell?) "Calm down, I know what I'm doing!"
          ask? "Sure."
          yell? "Whoa, chill out!"
          :else "Whatever.")))
