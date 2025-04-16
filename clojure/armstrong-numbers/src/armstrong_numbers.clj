(ns armstrong-numbers)

(defn int-to-seq
  ([num]
   (int-to-seq num '()))

  ([num splits]
   (let [dividen (bigint (/ num 10))]
     (if (zero? dividen)
       (conj splits num)
       (int-to-seq dividen
                   (conj splits (rem num 10)))))))

(defn power [base n]
  (apply * (repeat n base)))

(defn armstrong?
  "Returns true if the given number is an Armstrong number; otherwise, returns false"
  [num]
  (let [digit (int-to-seq num)
        length (count digit)]
    (= num
       (apply + (map #(power % length) digit)))))
