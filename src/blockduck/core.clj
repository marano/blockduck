(ns blockduck.core
  (:use [blockduck.piece]))

(defn won? [player-remaining-pieces]
  (if (empty? player-remaining-pieces) true false))

(defn spots [placed-pieces] 
  (if (empty? placed-pieces)
    [{:x 0 :y 0} {:x 0 :y 19} {:x 19 :y 0} {:x 19 :y 19}]
    (corners-for-monimo (first placed-pieces))))
