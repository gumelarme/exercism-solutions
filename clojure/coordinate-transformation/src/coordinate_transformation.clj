(ns coordinate-transformation)

(defn translate2d
  "Returns a function making use of a closure to
   perform a repeatable 2d translation of a coordinate pair."
  [& dpos]
  (fn [& pos] (mapv + dpos pos)))

(defn scale2d
  "Returns a function making use of a closure to
   perform a repeatable 2d scale of a coordinate pair."
  [& dpos]
  (fn [& pos] (mapv * dpos pos)))

(defn compose-transform
  "Create a composition function that returns a function that 
   combines two functions to perform a repeatable transformation."
  [f g]
  (fn [x y]
    (apply g (f x y))))
(defn memoize-transform
  "Returns a function that memoizes the last result.
   If the arguments are the same as the last call,
   the memoized result is returned."
  [f]
  (let [memo (atom [])]
    (fn [& args]
      (let [[mem-ret & mem-args] @memo]
        (if (= args mem-args)
          mem-ret
          (let [ret (apply f args)]
            (reset! memo (apply conj [ret] args))
            ret))))))

(def times-3 (scale2d 3 3))
(def memo-3 (memoize-transform times-3))
(memo-3 3 3)
