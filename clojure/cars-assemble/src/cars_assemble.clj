(ns cars-assemble)
(def rate-per-hour 221.0)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [success-rate (condp <= speed
                       10 0.77
                       9 0.8
                       5 0.9
                       1 1.0
                       0 0.0)]
    (* rate-per-hour speed success-rate))
  )

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))
