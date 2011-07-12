(ns blockduck.piece)

(defn corners-for-monomino [location]
  [{:x (- (:x location) 1) :y (- (:y location) 1)}
   {:x (+ (:x location) 1) :y (- (:y location) 1)}
   {:x (- (:x location) 1) :y (+ (:y location) 1)}
   {:x (+ (:x location) 1) :y (+ (:y location) 1)}])

(defn spots-blocked-by-monomino [location]
  [location
   {:x (:x location) :y (- (:y location) 1)}
   {:x (:x location) :y (+ (:y location) 1)}
   {:x (- (:x location) 1) :y (:y location)}
   {:x (+ (:x location) 1) :y (:y location)}])

(defn absolute-location [reference-location relative-location]
  {:x (+ (:x reference-location) (:x relative-location)) :y (+ (:y reference-location) (:y relative-location))})

(defn absolute-locations [reference-location relative-locations]
  (map (fn [relative-location] (absolute-location reference-location relative-location)) relative-locations))

(defn spots-blocked-by-piece [central-piece other-pieces]
  (distinct (concat (spots-blocked-by-monomino central-piece)
                    (mapcat spots-blocked-by-monomino (absolute-locations central-piece other-pieces)))))

(defn corners-for-piece [central-piece other-pieces]
  (let [corners-for-all-pieces (concat (corners-for-monomino central-piece) (mapcat corners-for-monomino (absolute-locations central-piece other-pieces)))]
    (distinct corners-for-all-pieces)))

(defn available-corners-for-piece [central-piece other-pieces]
  (let [blocked-spots (spots-blocked-by-piece central-piece other-pieces)]
    (filter
      (complement (fn [possible-monomino]
                    (some (fn [impossible-monomino]
                            (= possible-monomino impossible-monomino)) blocked-spots)))
      (corners-for-piece central-piece other-pieces))))

(defn relative-rotate-monomino [monomino times]
  (let [current-x (:x monomino)
        current-y (:y monomino)
        new-x (if (= times 1) current-y (if (= times 2) (* -1 current-x) (* -1 current-y)))
        new-y (if (= times 1) (* -1 current-x) (if (= times 2) (* -1 current-y) current-x))]
    {:x new-x :y new-y}))

(defn relative-rotate-pieces [other-pieces times]
  (map (fn [piece] (relative-rotate-monomino piece times)) other-pieces))

(defn monomino-at [location]
  (let [x (:x location)
        y (:y location)]
    {:x x :y y :corners #(corners-for-monomino {:x x :y y})}))
