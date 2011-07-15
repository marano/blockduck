(ns blockduck.test.piece
  (:use [blockduck.piece])
  (:use [blockduck.point])
  (:use [midje.sweet]))

(fact "tells piece board points"
  (let [reference-point (xy 1 1)
        blocks (xys 0 0, 0 1)
        piece (piece reference-point blocks)]
    (piece-board-points piece) => (xys 1 1, 1 2)))

(fact "tells corners for a triomino without overlaping corners"
  (let [a-piece (piece (xy 1 1) (xys 0 0, 0 1, 0 2))]
    (piece-corners a-piece) => (xys 0 0, 2 0, 0 2, 2 2, 0 1, 2 1, 0 3, 2 3, 0 4, 2 4)))

(fact "tells points blocked by piece"
  (let [a-piece (piece (xy 1 1) (xys 0 0))]
    (points-blocked-by-piece a-piece) => (xys 1 1, 1 0, 1 2, 0 1, 2 1)))
