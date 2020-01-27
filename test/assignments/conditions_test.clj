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

(deftest repeat-and-truncate-test
  (testing "repeat"
    (is (= '(1 2 3 1 2 3) (repeat-and-truncate [1 2 3] true false 5))))
  (testing "truncate"
    (is (= '(1 2) (repeat-and-truncate [1 2 3] false true 2))))
  (testing "repeat and truncate"
    (is (= '(1 2 3 1 2) (repeat-and-truncate [1 2 3] true true 5))))
  )

(deftest order-in-words-test
  (testing "for x > y and y > z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
  (testing "for x > y and z > y"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
  (testing "for z > x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 4)))))

(deftest zero-aliases-test
  (testing "0 -> :zero" (is (= :zero (zero-aliases 0))))
  (testing "[] -> :empty" (is (= :empty (zero-aliases []))))
  (testing "'() -> :empty" (is (= :empty (zero-aliases '()))))
  (testing "#{} -> :empty-set" (is (= :empty-set (zero-aliases #{}))))
  (testing "{} -> :empty-map" (is (= :empty-map (zero-aliases {}))))
  (testing "\"\" -> :empty-string" (is (= :empty-string (zero-aliases "")))))

(deftest zero-separated-palindrome-test
  (testing "[1 2 3] -> (4 3 2 0 2 3 4)"
    (is (= '(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3])))
    (is (= '(:a 0 :a) (zero-separated-palindrome [:a])))
    ))
