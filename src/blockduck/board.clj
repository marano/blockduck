(ns blockduck.board
  (:use [blockduck.collection])
  (:use [blockduck.point])
  (:use [blockduck.piece])
  (:use [blockduck.player]))

(defrecord Board [size players])

(defn board [size players] (Board. size players))

(defn- is-inside-the-board [board point]
  (and (>= (:x point)  0)
       (>= (:y point)  0)
       (<  (:x point) (:size board))
       (<  (:y point) (:size board))))

(defn board-corners-for-player [a-board a-player]
  (filter #(is-inside-the-board a-board %) (diff (player-corners a-player) (points-blocked-by-player a-player))))
