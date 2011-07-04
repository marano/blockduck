(ns blockduck.test.core
  (:use [blockduck.core])
  (:use [clojure.test]))

(deftest shouldWinTheGameWhenThereAreNoPieceLeft
  (is won? []))

(deftest shouldNotWinTheGameWhenThereArePiecesLeft
  (is (= false (won? ["a-piece"]))))

(deftest aNewMapShouldHaveTheFourCornersAsPossibleSpots
  (is (= [[0 0] [0 19] [19 0] [19 19]] (spots []))))

(deftest afterTheFirstPieceNextPiecesShouldTouchOtherPieces
  (is (= [[0 0] [2 0] [0 2] [2 2]] (spots [[[1 1]]]))))
