(ns blockduck.test.point
  (:use [blockduck.point])
  (:use [midje.sweet]))

(fact "creates a list of points"
      (xys 1 0, 0 1, 1 0) => [(xy 1 0) (xy 0 1) (xy 1 0)])

(fact "tells the point on the board for a relative point based on a reference point"
      (let [reference-point (xy 1 1)
            relative-point (xy 0 1)]
        (point-on-the-board reference-point relative-point) => (xy 1 2)))

(fact "tells points on the board for a list of relative points based on a reference point"
      (let [reference-point (xy 1 1)
            relative-points (xys 0 0, 0 1)]
        (points-on-the-board reference-point relative-points) => (xys 1 1, 1 2)))

(fact "tells corners for point"
      (point-corners (xy 1 1)) => (xys 0 0, 2 0, 0 2, 2 2)
      (point-corners (xy 0 0)) => (xys 1 1)
      (point-corners (xy 19 19)) => (xys 18 18))

(fact "tells points blocked by a point"
      (points-blocked-by-point (xy 1 1)) => (xys 1 1, 1 0, 1 2, 0 1, 2 1)
      (points-blocked-by-point (xy 0 0)) => (xys 0 0, 0 1, 1 0))

(fact "flips point"
      (flip-point (xy -1 1)) => (xy 1 1))

(fact "ratates point"
      (rotate-point-90 (xy -1 2)) => (xy 2 1)
      (rotate-point-180 (xy -1 2)) => (xy 1 -2)
      (rotate-point-270 (xy -1 2)) => (xy -2 -1))
