(ns blockduck.piece
  (:use [blockduck.point]))

(defrecord Piece [reference-point blocks])

(defn piece [reference-point blocks] (Piece. reference-point blocks))

(defn piece-points-on-the-board [piece]
  (points-on-the-board (:reference-point piece) (:blocks piece)))

(defn piece-corners [piece]
  (distinct (mapcat point-corners (piece-points-on-the-board piece))))

(defn points-blocked-by-piece [piece]
  (distinct (mapcat points-blocked-by-point (piece-points-on-the-board piece))))
