(ns blockduck.player
  (:use [blockduck.piece]))

(defrecord Player [pieces])

(defn player [pieces] (Player. pieces))

(defn player-corners [player]
  (mapcat piece-corners (:pieces player)))

(defn points-blocked-by-player [player]
  (mapcat points-blocked-by-piece (:pieces player)))
