(ns blockduck.test.piece
  (:use [blockduck.piece])
  (:use [clojure.test]))

(deftest shouldTellCornersForAMonimo 
  (is (= [[0 0] [2 0] [0 2] [2 2]] (corners-for-monimo [1 1]))))
