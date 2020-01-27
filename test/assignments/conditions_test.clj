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
    (is (true? (harishchandra true))))
  (testing "Falsy values"
    (is (nil? (harishchandra false)))
    (is (nil? (harishchandra nil)))))

(deftest yudishtira-test
  (testing "non falsy values"
    (is (true? (yudishtira true))))
  (testing "Falsy values"
    (is (= :ashwathama (yudishtira false)))
    (is (= :ashwathama (yudishtira nil)))))

(deftest duplicate-first-test
  (testing "non empty list"
    (is (= [1 1 2 3] (duplicate-first [1 2 3]))))
  (testing "empty list"
    (is (nil? (duplicate-first [])))))

(deftest five-point-someone-test
  (testing "second arg is 5"
    (is (= :chetan-bhagat (five-point-someone 3 5))))
  (testing "first arg is 5"
    (is (= :satan-bhagat (five-point-someone 5 6))))
  (testing "first arg is greater than second arg"
    (is (= :greece (five-point-someone 7 6))))
  (testing "else part"
    (is (= :universe (five-point-someone 3 3)))))

(deftest conditions-apply-test
  (testing "single occurrence of 1 and 3 in that order"
    (is (= :wonder-woman (conditions-apply [1 3 2 4]))))
  (testing "single occurrence of :a :b and :c in that order"
    (is (= :durga (conditions-apply [:a :b :c :d]))))
  (testing "single occurrence of [2 3] and [4 5] in that order"
    (is (= :cleopatra (conditions-apply [[2 3] [4 5]]))))
  (testing "else part"
    (is (= :tuntun (conditions-apply [0 9 8 7 6]))))
  )
