(ns blockduck.board
  (:use [blockduck.collection])
  (:use [blockduck.point])
  (:use [blockduck.piece])
  (:use [blockduck.player]))

(defrecord Board [players])

(defn board [players] (Board. players))

(defn board-corners-for-player [a-board a-player]
  (diff (player-corners a-player) (points-blocked-by-player a-player)))
