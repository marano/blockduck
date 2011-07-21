(ns blockduck.test.board
  (:use [blockduck.board])
  (:use [blockduck.point])
  (:use [blockduck.piece])
  (:use [midje.sweet]))

(fact "tells available corners the board"
      (board-corners (board [(piece (xy 0 0) (xys 0 0))])) => [(xy 1 1)])
