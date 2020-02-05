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
    (is (= '(1 2 3 4) (distinct' [1 2 1 2 3 4])))
    (is (= '() (distinct' [])))))

(deftest double-up-test
  (testing "double up"
    (is (= [1 1 2 2 3 3] (double-up [1 2 3])))))

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
    (is (= [1 4 6 7] (third-or-fifth [1 2 3 4 5 6 7 8])))))

(deftest russian-dolls-test
  (testing "[1 2 3] 3 => [[[1]] [[2]] [[3]]]"
    (is (= [[[1]] [[2]] [[3]]] (russian-dolls [1 2 3] 3)))
    (is (= [1 2 3] (russian-dolls [1 2 3] 1)))))

(deftest union-test
  (testing "get union"
    (is (= '(1 2 3 4 5) (union [1 2 3 4] [1 2 3 4 5])))))

(deftest difference-test
  (testing "get intersection"
    (is (= [4 5] (difference [1 2 3] [1 2 3 4 5])))))

(deftest difference-test
  (testing "get intersection"
    (is (= [4 5] (difference [1 2 3] [1 2 3 4 5])))))

(deftest transpose-test
  (testing "transpose"
    (is (= [[:a :c] [:b :d]] (transpose [[:a :b] [:c :d]])))))

(deftest cross-product-test
  (testing "cross product of 3 * 3"
    (is (= [[1 4] [1 3] [1 5] [2 4] [2 3] [2 5] [3 4]]
           (cross-product [1 2 3] [4 3 5])))))

(deftest points-around-origin-test
  (testing "points around origin"
    (is (= '([-1 -1]
             [-1 0]
             [-1 1]
             [0 -1]
             [0 1]
             [1 -1]
             [1 0]
             [1 1]) points-around-origin))))

(deftest split-comb-test
  (testing "with odd sequence"
    (is (= [1 3 2 4 5] (split-comb [1 2 3 4 5])))))

(deftest validate-sudoku-grid-test
  (testing "valid grid"
    (is (true? (validate-sudoku-grid
                 [[6 8 2 5 7 1 4 9 3]
                  [4 3 5 2 6 9 7 8 1]
                  [1 9 7 8 3 4 5 6 2]
                  [8 2 6 1 9 5 3 4 7]
                  [3 7 4 6 8 2 9 1 5]
                  [9 5 1 7 4 3 6 2 8]
                  [5 1 9 3 2 6 8 7 4]
                  [2 4 8 9 5 7 1 3 6]
                  [7 6 3 4 1 8 2 5 9]]))))
  (testing "invalid grid"
    (is (false? (validate-sudoku-grid
                  [[4 3 5 2 6 9 7 8 1]
                   [4 8 2 5 7 1 4 9 3]
                   [1 9 7 8 3 4 5 6 2]
                   [8 2 6 1 9 5 3 4 7]
                   [3 7 4 6 8 2 9 1 5]
                   [9 5 1 7 4 3 6 2 8]
                   [5 1 9 3 2 6 8 7 4]
                   [2 4 8 9 5 7 1 3 6]
                   [7 6 3 4 1 8 2 5 9]])))))

(deftest dedupe'-test
  (testing "dedupe should not remove any element"
    (is (= [1 2 3 1] (dedupe' [1 2 3 1]))))
  (testing "dedupe should remove consecutive duplicates"
    (is (= [1 2 3 1] (dedupe' [1 2 2 3 1])))))

(deftest max-three-digit-sequence-test
  (testing "give sequence if three digits who yields max sum"
    (is (= [2 -1 2] (max-three-digit-sequence [1 2 -1 2 0])))))
