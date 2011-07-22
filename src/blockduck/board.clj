(ns blockduck.board
  (:use [blockduck.collection])
  (:use [blockduck.point])
  (:use [blockduck.piece]))

(defrecord Board [pieces])

(defn board [pieces] (Board. pieces))

(defn board-corners [board]
  (diff
    (mapcat piece-corners (:pieces board))
    (mapcat points-blocked-by-piece (:pieces board))))
