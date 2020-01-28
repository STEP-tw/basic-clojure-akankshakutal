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
    (is (= true (every?' even? [2 4 6])))
    (is (= false (every?' even? [1 2 3 4 5 6])))
    ))
