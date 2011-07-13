(ns blockduck.test.piece
  (:use [blockduck.piece])
  (:use [midje.sweet]))

(fact "tells corners for a monomino"
  (corners-for-monomino {:x 1 :y 1}) => [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2}])

(fact "tells corners for a domino"
  (corners-for-piece {:x 1 :y 1} [{:x 0 :y 1}]) => [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2} {:x 0 :y 1} {:x 2 :y 1} {:x 0 :y 3} {:x 2 :y 3}])

(fact "tells corners for a triomino and do not duplicate overlaping corners"
  (corners-for-piece {:x 1 :y 1} [{:x 0 :y 1} {:x 0 :y 2}]) => [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2} {:x 0 :y 1} {:x 2 :y 1} {:x 0 :y 3} {:x 2 :y 3} {:x 0 :y 4} {:x 2 :y 4}])

(fact "tells spots blocked by a monomino"
  (spots-blocked-by-monomino {:x 1 :y 1}) => [{:x 1 :y 1} {:x 1 :y 0} {:x 1 :y 2} {:x 0 :y 1} {:x 2 :y 1}])

(fact "tells spots blocked by a domino and not duplicate overlaping spots"
  (spots-blocked-by-piece {:x 1 :y 1} [{:x 0 :y 1}]) => [{:x 1 :y 1} {:x 1 :y 0} {:x 1 :y 2} {:x 0 :y 1} {:x 2 :y 1} {:x 1 :y 3} {:x 0 :y 2} {:x 2 :y 2}])

(fact "tells available corners for a domino"
  (available-corners-for-piece {:x 1 :y 1} [{:x 0 :y 1}]) => [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 3} {:x 2 :y 3}])

(fact "tells available corners for a triomino"
  (available-corners-for-piece {:x 1 :y 1} [{:x 1 :y 0} {:x 0 :y 1}]) => [{:x 0 :y 0} {:x 3 :y 0} {:x 3 :y 2} {:x 0 :y 3} {:x 2 :y 3}])

(fact "tells absolute location based on relative position"
  (absolute-location {:x 2 :y 2} {:x 1 :y 0}) => {:x 3 :y 2}
  (absolute-location {:x 2 :y 2} {:x -1 :y 0}) => {:x 1 :y 2}
  (absolute-location {:x 2 :y 2} {:x 0 :y 1}) => {:x 2 :y 3}
  (absolute-location {:x 2 :y 2} {:x 0 :y -1}) => {:x 2 :y 1})

(fact "tells the absolute location of a list of relative locations"
  (absolute-locations {:x 1 :y 1} [{:x 0 :y 1}]) => [{:x 1 :y 2}])

(fact "tells the new spot for a relative rotated monomino"
  (relative-rotate-monomino {:x -1 :y 2} 1) => {:x 2 :y 1}
  (relative-rotate-monomino {:x -1 :y 2} 2) => {:x 1 :y -2}
  (relative-rotate-monomino {:x -1 :y 2} 3) => {:x -2 :y -1})

(fact "tells new spots for rotated piece"
  (relative-rotate-pieces [{:x 1 :y 1} {:x 0 :y 1}] 1) => [{:x 1 :y -1} {:x 1 :y 0}])

(fact "tells new spot for relative fliped monomino"
  (relative-flip-monomino {:x -1 :y 1}) => {:x 1 :y 1})

(fact "tells new spots for a relative fliped piece"
  (relative-flip-pieces [{:x -1 :y 0} {:x -1 :y 1} {:x 1 :y 0} {:x 1 :y -1}]) => [{:x 1 :y 0} {:x 1 :y 1} {:x -1 :y 0} {:x -1 :y -1} ])
