(ns blockduck.test.piece
  (:use [blockduck.piece])
  (:use [clojure.test]))

(deftest shouldTellCornersForAMonimo 
  (is (= [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2}] (corners-for-monimo {:x 1 :y 1}))))

(deftest shouldTellCornersForADomino
  (is (= [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2} {:x 0 :y 1} {:x 2 :y 1} {:x 0 :y 3} {:x 2 :y 3}] (corners-for-domino {:x 1 :y 1} [{:x 1 :y 2}]))))

(deftest shouldTellCornersBlockedByAMonimo
  (is (= [{:x 1 :y 0} {:x 1 :y 2} {:x 0 :y 1} {:x 2 :y 1}] (corners-blocked-by-monimo {:x 1 :y 1}))))

(deftest shouldTellCornersBlockedByADomino
  (is (= [{:x 1 :y 0} {:x 1 :y 2} {:x 0 :y 1} {:x 2 :y 1} {:x 1 :y 1} {:x 1 :y 3} {:x 0 :y 2} {:x 2 :y 2}] (corners-blocked-by-domino {:x 1 :y 1} [{:x 1 :y 2}]))))

(deftest shouldTellAvailableCornersForADomino
  (is (= [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 3} {:x 2 :y 3}] (available-corners-for-domino {:x 1 :y 1} [{:x 1 :y 2}]))))
