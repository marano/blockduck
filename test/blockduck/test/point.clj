(ns blockduck.test.point
  (:use [blockduck.point])
  (:use [midje.sweet]))

(fact "creates a list of points"
  (points 0 0, 0 1, 1 0) => [(point 0 0) (point 0 1) (point 1 0)])

(fact "tells the point on the board for a relative point based on a reference point"
  (let [reference-point (point 1 1)
        relative-point (point 0 1)]
    (board-point reference-point relative-point) => (point 1 2)))

(fact "tells points on the board for a list of relative points based on a reference point"
  (let [reference-point (point 1 1)
        relative-points (points 0 0, 0 1)]
    (board-points reference-point relative-points) => (points 1 1, 1 2)))

(fact "tells points touched by point"
  (points-touched-by-point (point 1 1)) => (points 0 0, 2 0, 0 2, 2 2))

(fact "tells points blocked by a point"
  (points-blocked-by-point (point 1 1)) => (points 1 1, 1 0, 1 2, 0 1, 2 1))
