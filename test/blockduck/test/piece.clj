(ns blockduck.test.piece
  (:use [blockduck.piece])
  (:use [midje.sweet]))

(fact "tells corners for a monomino"
  (corners-for-monomino {:x 1 :y 1}) => [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2}])

(fact "tells corners for a domino"
  (corners-for-piece {:x 1 :y 1} [{:x 1 :y 2}]) => [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2} {:x 0 :y 1} {:x 2 :y 1} {:x 0 :y 3} {:x 2 :y 3}])

(fact "tells corners for a triomino and do not duplicate overlaping corners"
  (corners-for-piece {:x 1 :y 1} [{:x 1 :y 2} {:x 1 :y 3}]) => [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2} {:x 0 :y 1} {:x 2 :y 1} {:x 0 :y 3} {:x 2 :y 3} {:x 0 :y 4} {:x 2 :y 4}])

(fact "tells spots blocked by a monomino"
  (spots-blocked-by-monomino {:x 1 :y 1}) => [{:x 1 :y 1} {:x 1 :y 0} {:x 1 :y 2} {:x 0 :y 1} {:x 2 :y 1}])

(fact "tells spots blocked by a domino and not duplicate overlaping spots"
  (spots-blocked-by-domino {:x 1 :y 1} [{:x 1 :y 2}]) => [{:x 1 :y 1} {:x 1 :y 0} {:x 1 :y 2} {:x 0 :y 1} {:x 2 :y 1} {:x 1 :y 3} {:x 0 :y 2} {:x 2 :y 2}])

(fact "tells available corners for a domino"
  (available-corners-for-domino {:x 1 :y 1} [{:x 1 :y 2}]) => [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 3} {:x 2 :y 3}])
