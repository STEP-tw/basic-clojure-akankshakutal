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