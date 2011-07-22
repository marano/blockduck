(ns blockduck.test.player
  (:use [blockduck.player])
  (:use [blockduck.board])
  (:use [blockduck.point])
  (:use [blockduck.piece])
  (:use [midje.sweet]))

(fact "tells corners for player"
      (player-corners (player [(piece (xy 0 0) (xys 0 0))])) => (xys -1 -1, 1 -1, -1 1, 1 1))

(fact "tells points blocked by player"
      (points-blocked-by-player (player [(piece (xy 0 0) (xys 0 0))])) => (xys 0 -1, 0 1, -1 0, 1 0))
