(ns blockduck.test.piece
  (:use [blockduck.piece])
  (:use [blockduck.point])
  (:use [midje.sweet]))

(fact "tells piece board points"
  (let [reference-point (point 1 1)
        blocks (points 0 0, 0 1)
        piece (piece reference-point blocks)]
    (piece-board-points piece) => (points 1 1, 1 2)))

(fact "tells points touched by a triomino and do not duplicate overlaping points"
  (let [a-piece (piece (point 1 1) (points 0 0, 0 1, 0 2))]
    (points-touched-by-piece a-piece) => (points 0 0, 2 0, 0 2, 2 2, 0 1, 2 1, 0 3, 2 3, 0 4, 2 4)))

(fact "tells points blocked by piece"
  (let [a-piece (piece (point 1 1) (points 0 0))]
    (points-blocked-by-piece a-piece) => (points 1 1, 1 0, 1 2, 0 1, 2 1)))
