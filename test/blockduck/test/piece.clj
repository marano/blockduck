(ns blockduck.test.piece
  (:use [blockduck.piece])
  (:use [clojure.test]))

(deftest shouldTellCornersForAMonimo 
  (is (= [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2}] (corners-for-monimo {:x 1 :y 1}))))
