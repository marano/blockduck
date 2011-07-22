(ns blockduck.test.collection
  (:use [blockduck.collection])
  (:use [midje.sweet]))

(fact "tells left outer join"
      (diff [1 2 3 4] [3 4]) => [1 2])
