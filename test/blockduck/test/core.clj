(ns blockduck.test.core
  (:use [blockduck.core])
  (:use [blockduck.piece])
  (:use [midje.sweet]))

(fact "wins the game when there are no piece left"
  (won? []) => true)

(fact "doesnt win the game when there are pieces left"
  (won? ["a-piece"]) => false)

(fact "a new map should have the four corners as possible spots"
  (spots []) => [{:x 0 :y 0} {:x 0 :y 19} {:x 19 :y 0} {:x 19 :y 19}])

(fact "after the first piece next pieces should touch other pieces"
  (spots [(monomino-at {:x 1 :y 1})]) => [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2}])
