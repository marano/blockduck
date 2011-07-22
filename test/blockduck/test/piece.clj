(ns blockduck.test.piece
  (:use [blockduck.piece])
  (:use [blockduck.point])
  (:use [midje.sweet]))

(fact "tells piece points on the board"
      (let [reference-point (xy 1 1)
            blocks (xys 0 0, 0 1)
            piece (piece reference-point blocks)]
        (piece-points-on-the-board piece) => (xys 1 1, 1 2)))

(fact "tells points blocked by a given piece"
      (let [a-piece (piece (xy 1 1) (xys 0 0, 0 1))]
        (points-blocked-by-piece a-piece) => (xys 1 1, 1 0, 1 2, 0 1, 2 1, 1 3, 0 2, 2 2)))

(fact "tells corners for a given piece"
      (let [a-piece (piece (xy 1 1) (xys 0 0, 0 1, 0 2))]
        (piece-corners a-piece) => (xys 0 0, 2 0, 0 4, 2 4)))

(fact "flips piece"
      (flip-piece (piece (xy 1 1) (xys 0 0, 1 0, 0 1))) => (piece (xy 1 1) (xys 0 0, -1 0, 0 1)))

(fact "rotates piece"
      (rotate-piece-90 (piece (xy 1 1) (xys 0 0, 0 1))) => (piece (xy 1 1) (xys 0 0, 1 0))
      (rotate-piece-180 (piece (xy 1 1) (xys 0 0, 0 1))) => (piece (xy 1 1) (xys 0 0, 0 -1))
      (rotate-piece-270 (piece (xy 1 1) (xys 0 0, 0 1))) => (piece (xy 1 1) (xys 0 0, -1 0)))
