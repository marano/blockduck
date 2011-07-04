(ns blockduck.test.core
  (:use [blockduck.core])
  (:use [blockduck.piece])
  (:use [clojure.test]))

(deftest shouldWinTheGameWhenThereAreNoPieceLeft
  (is won? []))

(deftest shouldNotWinTheGameWhenThereArePiecesLeft
  (is (= false (won? ["a-piece"]))))

(deftest aNewMapShouldHaveTheFourCornersAsPossibleSpots
  (is (= [{:x 0 :y 0} {:x 0 :y 19} {:x 19 :y 0} {:x 19 :y 19}] (spots []))))

(deftest afterTheFirstPieceNextPiecesShouldTouchOtherPieces
  (is (= [{:x 0 :y 0} {:x 2 :y 0} {:x 0 :y 2} {:x 2 :y 2}] (spots [(monimo-at {:x 1 :y 1})]))))
