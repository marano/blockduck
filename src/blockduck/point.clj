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

(defn board-points [reference-point relative-points]
  (map #(board-point reference-point %) relative-points))

(defn points-touched-by-point [a-point]
  (let [x (:x a-point)
        y (:y a-point)]
    (xys (- x 1) (- y 1)
         (+ x 1) (- y 1)
         (- x 1) (+ y 1)
         (+ x 1) (+ y 1))))

(defn points-blocked-by-point [a-point]
  (let [x (:x a-point)
        y (:y a-point)]
    (xys x y
         x (- y 1)
         x (+ y 1)
         (- x 1) y
         (+ x 1) y)))
