(ns blockduck.piece)

(defn corners-for-monimo [location]
  [[(- (get location 0) 1) (- (get location 1) 1)] [(+ (get location 0) 1) (- (get location 1) 1)] [(- (get location 0) 1) (+ (get location 1) 1)] [(+ (get location 0) 1) (+ (get location 1) 1)]])
