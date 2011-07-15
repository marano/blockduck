(ns blockduck.test.point
  (:use [blockduck.point])
  (:use [midje.sweet]))

(fact "creates a list of points"
  (xys 1 0, 0 1, 1 0) => [(xy 1 0) (xy 0 1) (xy 1 0)])

(fact "tells the point on the board for a relative point based on a reference point"
  (let [reference-point (xy 1 1)
        relative-point (xy 0 1)]
    (board-point reference-point relative-point) => (xy 1 2)))

(fact "tells points on the board for a list of relative points based on a reference point"
  (let [reference-point (xy 1 1)
        relative-points (xys 0 0, 0 1)]
    (board-points reference-point relative-points) => (xys 1 1, 1 2)))

(fact "tells corners for point"
  (point-corners (xy 1 1)) => (xys 0 0, 2 0, 0 2, 2 2))

(fact "tells points blocked by a point"
  (points-blocked-by-point (xy 1 1)) => (xys 1 1, 1 0, 1 2, 0 1, 2 1))
