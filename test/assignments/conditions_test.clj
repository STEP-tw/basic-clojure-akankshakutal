(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-divide-test
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 4 0)))))

(deftest harishchandra-test
  (testing "non falsy values"
    (is (= true (harishchandra true))))
  (testing "Falsy values"
    (is (nil? (harishchandra false)))
    (is (nil? (harishchandra nil)))))

(deftest yudishtira-test
  (testing "non falsy values"
    (is (= true (yudishtira true))))
  (testing "Falsy values"
    (is (= :ashwathama (yudishtira false)))
    (is (= :ashwathama (yudishtira nil)))))
