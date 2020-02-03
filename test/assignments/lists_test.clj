(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))
    (testing "operation with single coll"
      (is (= [2 3 4] (map' inc [1 2 3]))))
    (testing "identity with multiple coll"
      (is (= [3 5 7] (map' + [1 2 3] [2 3 4]))))))

(deftest filter'-test
  (testing "filter"
    (is (= [2 4 6] (filter' even? [1 2 3 4 5 6])))))

(deftest count'-test
  (testing "count'"
    (is (= 4 (count' [1 2 3 4])))
    (is (= 4 (count' '(1 2 3 4))))
    (is (= 4 (count' "word")))))

(deftest reduce'-test
  (testing "reduce"
    (is (= 6 (reduce' + [1 2 3])))
    (is (= 10 (reduce' + 4 [1 2 3])))
    (is (= 0 (reduce' + [])))))

(deftest reverse'-test
  (testing "reverse"
    (is (= [3 2 1] (reverse' [1 2 3])))
    (is (= nil (reverse' 1)))))

(deftest every?'-test
  (testing "every'"
    (is (true? (every?' even? [2 4 6])))
    (is (false? (every?' even? [1 2 3 4 5 6])))
    ))

(deftest some?'-test
  (testing "some?"
    (is (true? (some?' even? [1 2 3])))
    (is (false? (some?' even? [1 5 3])))))

(deftest ascending?-test
  (testing "ascending?"
    (is (true? (ascending? [1 2 3 4])))
    (is (false? (ascending? [1 3 2 4])))
    ))

(deftest distinct'-test
  (testing "distinct"
    (is (= '(2 3 4 1) (distinct' [1 2 1 2 3 4])))
    (is (= '() (distinct' [])))
    ))

(deftest double-up-test
  (testing "double up"
    (is (= [1 1 2 2 3 3] (double-up [1 2 3])))))

;(deftest dedupe'-test
;  (testing "dedupe"
;    (is (= [1 2] (dedupe' [1 1 2 2])))
;    ))

(deftest sum-of-adjacent-digits-test
  (testing "sum of adjacent"
    (is (= [3 5] (sum-of-adjacent-digits [1 2 3]))))
  )

(deftest palindrome?-test
  (testing "Palindrome"
    (is (true? (palindrome? [1 2 1])))
    (is (true? (palindrome? [])))
    (is (false? (palindrome? [1 2 3])))))

(deftest index-of-test
  (testing "index of"
    (is (= 4 (index-of [2 3 4 5 1] 1)))
    (is (= -1 (index-of [2 3 4 5 1] 8)))
    ))

(deftest muted-thirds-test
  (testing "muted third [1 2 8 4 15 2 7] => [1 2 0 4 15 0 7]"
    (is (= [1 2 0 4 15 0 7] (muted-thirds [1 2 8 4 15 2 7])))))

(deftest sqr-of-the-first-test
  (testing "squre of first [4 5 6] => [16 16 16]"
    (is (= [16 16 16] (sqr-of-the-first [4 5 6]))))
  )

(deftest third-or-fifth-test
  (testing "get third or fifth element"
    ())
  )
