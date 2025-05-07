(ns two-fer)

(defn two-fer
  "Return what you will say as you give away the extra cookie"
  ([]
   (two-fer "you"))

  ([name]
   (format "One for %s, one for me." name)))

