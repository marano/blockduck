(ns blockduck.piece
  (:use [blockduck.point]))

(defrecord Piece [reference-point blocks])

(defn piece [reference-point blocks] (Piece. reference-point blocks))

(defn piece-board-points [piece]
  (board-points (:reference-point piece) (:blocks piece)))

(defn piece-corners [piece]
  (distinct (mapcat point-corners (piece-board-points piece))))

(defn points-blocked-by-piece [piece]
  (mapcat points-blocked-by-point (piece-board-points piece)))
