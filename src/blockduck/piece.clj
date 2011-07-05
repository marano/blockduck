(ns blockduck.piece)

(defn corners-for-monomino [location]
  [{:x (- (:x location) 1) :y (- (:y location) 1)}
   {:x (+ (:x location) 1) :y (- (:y location) 1)}
   {:x (- (:x location) 1) :y (+ (:y location) 1)}
   {:x (+ (:x location) 1) :y (+ (:y location) 1)}])

(defn corners-blocked-by-monomino [location]
  [location
   {:x (:x location) :y (- (:y location) 1)}
   {:x (:x location) :y (+ (:y location) 1)}
   {:x (- (:x location) 1) :y (:y location)}
   {:x (+ (:x location) 1) :y (:y location)}])

(defn corners-blocked-by-domino [central-piece other-pieces]
  (concat (corners-blocked-by-monomino central-piece)
          (mapcat corners-blocked-by-monomino other-pieces)))

(defn corners-for-domino [central-piece other-pieces]
  (let [corners-for-all-pieces (concat (corners-for-monomino central-piece)
                                       (mapcat corners-for-monomino other-pieces))]
    (distinct corners-for-all-pieces)))

(defn available-corners-for-domino [central-piece other-pieces]
  (let [blocked-spots (corners-blocked-by-domino central-piece other-pieces)]
    (filter
      (complement (fn [possible-monomino]
                    (some (fn [impossible-monomino]
                            (= possible-monomino impossible-monomino)) blocked-spots)))
      (corners-for-domino central-piece other-pieces))))

(defn monomino-at [location]
  (let [x (:x location)
        y (:y location)]
    {:x x :y y :corners #(corners-for-monomino {:x x :y y})}))
