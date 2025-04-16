(ns raindrops)

(defn convert
  "Converts a number to its corresponding string of raindrop sounds."
  [num]
  (let [mod-of? #(zero? (mod num %))]
    (cond-> nil
      (mod-of? 3) (str "Pling")
      (mod-of? 5) (str "Plang")
      (mod-of? 7) (str "Plong")
      :'always'-is-the-convention-but-anything-truthy-works-i-guess (or (str num)))))
                  