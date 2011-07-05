(ns blockduck.piece)

(defn corners-for-monimo [location]
  [{:x (- (:x location) 1) :y (- (:y location) 1)}
   {:x (+ (:x location) 1) :y (- (:y location) 1)}
   {:x (- (:x location) 1) :y (+ (:y location) 1)}
   {:x (+ (:x location) 1) :y (+ (:y location) 1)}])

(defn corners-blocked-by-monimo [location]
  [{:x (:x location) :y (- (:y location) 1)}
   {:x (:x location) :y (+ (:y location) 1)}
   {:x (- (:x location) 1) :y (:y location)}
   {:x (+ (:x location) 1) :y (:y location)}])

(defn corners-blocked-by-domino [central-piece other-pieces]
  (concat (corners-blocked-by-monimo central-piece)
          (mapcat corners-blocked-by-monimo other-pieces)))

(defn corners-for-domino [central-piece other-pieces]
  (concat (corners-for-monimo central-piece)
          (mapcat corners-for-monimo other-pieces)))

(defn available-corners-for-domino [central-piece other-pieces]
  (let [blocked-spots (corners-blocked-by-domino central-piece other-pieces)]
    (filter
      (complement
        (fn [possible-monimo]
          (some (fn [impossible-monimo]
                  (= possible-monimo impossible-monimo)) blocked-spots)))
      (corners-for-domino central-piece other-pieces))))

(defn monimo-at [location]
  (let [x (:x location)
        y (:y location)]
    {:x x :y y :corners #(corners-for-monimo {:x x :y y})}))
