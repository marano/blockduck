(ns blockduck.test.board
  (:use [blockduck.board])
  (:use [blockduck.point])
  (:use [blockduck.piece])
  (:use [blockduck.player])
  (:use [midje.sweet]))

(fact "tells available corners on the board"
      (let [red (player [(piece (xy 0 0) (xys 0 0)) (piece (xy 0 1) (xys 0 0))])
            players [red]
            board (board 20 players)]
        (board-corners-for-player board red) => [(xy 1 2)]))
