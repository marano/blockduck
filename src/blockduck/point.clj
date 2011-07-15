(ns blockduck.point)

(defrecord Point [x y])

(defn point [x y] (Point. x y))

(defn points [& coordinates]
  (map (fn [coordinates] (apply point coordinates)) (partition 2 coordinates)))

(defn board-point [reference-point relative-point]
  (let [x (+ (:x reference-point) (:x relative-point))
        y (+ (:y reference-point) (:y relative-point))]
    (Point. x y)))

(defn board-points [reference-point relative-points]
  (map #(board-point reference-point %) relative-points))

(defn points-touched-by-point [a-point]
  (let [x (:x a-point)
        y (:y a-point)]
    (points (- x 1) (- y 1)
            (+ x 1) (- y 1)
            (- x 1) (+ y 1)
            (+ x 1) (+ y 1))))

(defn points-blocked-by-point [a-point]
  (let [x (:x a-point)
        y (:y a-point)]
    (points x y
            x (- y 1)
            x (+ y 1)
            (- x 1) y
            (+ x 1) y)))
