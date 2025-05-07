(ns robot-simulator)

(defn robot
  "Creates a robot at the given coordinates, facing the given direction."
  [coordinates direction]
  {:coordinates coordinates
   :bearing direction})

(def compass
  [:north :east :south :west])

(defn turn
  [cur-dir target]
  (let [compass-count (count compass)
        cur (.indexOf compass cur-dir)
        go (condp = target
             \R (mod (inc cur) compass-count)
             \L (mod (dec cur) compass-count))]
    (compass go)))

(defn advance
  [bearing coord]
  (condp = bearing
    :north (update coord :y inc)
    :south (update coord :y dec)
    :east (update coord :x inc)
    :west (update coord :x dec)))

(defn simulate
  "Simulates the robot's movements based on the given instructions
  and updates its state."
  [instructions robot-state]
  (let [cmd (first instructions)
        tails (subs instructions 1)
        new-state (if (= \A cmd)
                    (update robot-state :coordinates #(advance (:bearing robot-state) %))
                    (update robot-state :bearing #(turn % cmd)))]

    (if (empty? tails)
      new-state
      (simulate tails new-state))))
