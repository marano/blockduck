(ns blockduck.core)

(defn won? [player-remaining-pieces]
  (if (empty? player-remaining-pieces) true false))

(defn spots [placed-pieces]
  (if (empty? placed-pieces) [[0 0] [0 19] [19 0] [19 19]]))
