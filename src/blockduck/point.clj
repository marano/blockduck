(ns blockduck.point)

(defrecord Point [x y])

(defn- point [x y] (Point. x y))

(def xy point)

(defn- points [& coordinates]
  (map (fn [coordinates] (apply xy coordinates)) (partition 2 coordinates)))

(def xys points)

(defn point-on-the-board [reference-point relative-point]
  (let [x (+ (:x reference-point) (:x relative-point))
        y (+ (:y reference-point) (:y relative-point))]
    (xy x y)))

(defn points-on-the-board [reference-point relative-points]
  (map #(point-on-the-board reference-point %) relative-points))

(defn- switch-xy [a-point] (xy       (:y a-point)       (:x a-point)))
(defn- invert-x  [a-point] (xy (* -1 (:x a-point))      (:y a-point)))
(defn- invert-y  [a-point] (xy       (:x a-point) (* -1 (:y a-point))))

(defn flip-point       [relative-point] (invert-x   relative-point))
(defn rotate-point-90  [relative-point] (switch-xy (invert-x relative-point)))
(defn rotate-point-180 [relative-point] (invert-x  (invert-y relative-point)))
(defn rotate-point-270 [relative-point] (switch-xy (invert-y relative-point)))

(defn- top    [a-point] (xy    (:x a-point)    (+ (:y a-point) 1)))
(defn- bottom [a-point] (xy    (:x a-point)    (- (:y a-point) 1)))
(defn- right  [a-point] (xy (+ (:x a-point) 1)    (:y a-point)))
(defn- left   [a-point] (xy (- (:x a-point) 1)    (:y a-point)))

(defn point-corners [a-point]
  [(bottom (left  a-point))
   (bottom (right a-point))
   (top    (left  a-point))
   (top    (right a-point))])

(defn points-blocked-by-point [a-point]
  [        a-point
   (bottom a-point)
   (top    a-point)
   (left   a-point)
   (right  a-point)])
