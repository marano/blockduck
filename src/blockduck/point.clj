(ns blockduck.point)

(defrecord Point [x y])

(defn- point [x y] (Point. x y))

(def xy point)

(defn- points [& coordinates]
  (map (fn [coordinates] (apply xy coordinates)) (partition 2 coordinates)))

(def xys points)

(defn board-point [reference-point relative-point]
  (let [x (+ (:x reference-point) (:x relative-point))
        y (+ (:y reference-point) (:y relative-point))]
    (xy x y)))

(defn points-on-the-board [reference-point relative-points]
  (map #(board-point reference-point %) relative-points))

(defn point-corners [a-point]
  (let [x (:x a-point)
        y (:y a-point)
        bottom-left-corner (xy (- x 1) (- y 1))
        bottom-right-corner (xy (+ x 1) (- y 1))
        top-left-corner (xy (- x 1) (+ y 1))
        top-right-corner (xy (+ x 1) (+ y 1))]
    [bottom-left-corner
     bottom-right-corner
     top-left-corner
     top-right-corner]))

(defn points-blocked-by-point [a-point]
  (let [x (:x a-point)
        y (:y a-point)]
    (xys x y
         x (- y 1)
         x (+ y 1)
         (- x 1) y
         (+ x 1) y)))
