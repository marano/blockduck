(ns blockduck.core)

(defn won? [pieces]
  (if (empty? pieces) true false))
