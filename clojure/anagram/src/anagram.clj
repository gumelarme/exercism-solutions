(ns anagram)

(require '[clojure.string :as str])

(defn is-anagram [a b]
  (let [left (str/lower-case a)
        right (str/lower-case b)]
    (and (= (sort left) (sort right))
         (not= left right))))

(defn anagrams-for [word prospect-list]
  (filterv #(is-anagram word %)
           prospect-list))
