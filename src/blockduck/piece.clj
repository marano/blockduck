(ns blockduck.piece
  (:use [blockduck.collection])
  (:use [blockduck.point]))

(defrecord Piece [reference-point blocks])

(defn piece [reference-point blocks] (Piece. reference-point blocks))

(defn piece-points-on-the-board [piece]
  (points-on-the-board (:reference-point piece) (:blocks piece)))

(defn points-blocked-by-piece [piece]
  (let [piece-points (piece-points-on-the-board piece)
        blocked-points (distinct (mapcat points-blocked-by-point piece-points))]
    (diff blocked-points piece-points)))

(defn piece-corners [a-piece]
      (let [blocked-points (points-blocked-by-piece a-piece)
            possible-corners (distinct (mapcat point-corners (piece-points-on-the-board a-piece)))]
        (diff possible-corners blocked-points)))

(defn flip-piece [a-piece]
  (piece (:reference-point a-piece) (map flip-point (:blocks a-piece))))

(defn rotate-piece-90 [a-piece]
  (piece (:reference-point a-piece) (map rotate-point-90 (:blocks a-piece))))

(defn rotate-piece-180 [a-piece]
  (piece (:reference-point a-piece) (map rotate-point-180 (:blocks a-piece))))

(defn rotate-piece-270 [a-piece]
  (piece (:reference-point a-piece) (map rotate-point-270 (:blocks a-piece))))
