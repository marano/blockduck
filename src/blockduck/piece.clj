(ns blockduck.piece)

(defn corners-for-monimo [location]
  [{:x (- (:x location) 1) :y (- (:y location) 1)}
   {:x (+ (:x location) 1) :y (- (:y location) 1)}
   {:x (- (:x location) 1) :y (+ (:y location) 1)}
   {:x (+ (:x location) 1) :y (+ (:y location) 1)}])
