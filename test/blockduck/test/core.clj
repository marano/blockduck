(ns blockduck.test.core
  (:use [blockduck.core])
  (:use [clojure.test]))

(deftest shouldWinTheGameWhenThereAreNoPieceLeft
  (is won? []))
