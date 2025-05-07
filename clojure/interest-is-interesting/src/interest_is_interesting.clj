(ns interest-is-interesting
  (:require [clojure.math :as math]))

(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]
  (condp #(< %2 %1) balance
    0 -3.213
    1000 0.5
    5000 1.621
    2.475))

(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  (let [interest (-> balance
                     (interest-rate)
                     (bigdec)
                     (/ 100))]
    (* balance
       (+ 1 (abs interest)))))

(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage]
  (if (neg? balance)
    0
    (int (* balance (/ tax-free-percentage 100) 2))))
