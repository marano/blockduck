(ns blockduck.piece)

(defn corners-for-monimo [location]
  [{:x (- (:x location) 1) :y (- (:y location) 1)}
   {:x (+ (:x location) 1) :y (- (:y location) 1)}
   {:x (- (:x location) 1) :y (+ (:y location) 1)}
   {:x (+ (:x location) 1) :y (+ (:y location) 1)}])

(defn possible-corners-for-domino [central-piece other-pieces]
  (concat (corners-for-monimo central-piece)
          (mapcat corners-for-monimo other-pieces)))


;(defn corners-for-domino [central-piece other-pieces]
;  (let possible-corners
;    (concat [(corners-for-monimo central-piece)]
;            (mapcat corners-for-monimo other-pieces))))

(defn monimo-at [location]
  (let [x (:x location)
        y (:y location)]
    {:x x :y y :corners #(corners-for-monimo {:x x :y y})}))
