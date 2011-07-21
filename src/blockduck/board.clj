(ns blockduck.board
  (:use [blockduck.point])
  (:use [blockduck.piece]))

(defrecord Board [pieces])

(defn board [pieces] (Board. pieces))

(defn board-corners [board]
  (mapcat piece-corners (:pieces board)))
