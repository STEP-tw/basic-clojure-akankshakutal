(ns assignments.util)

(defn implemented? [f]
  (-> f resolve meta :implemented?))

(defn insert-println-if-implemented [form]
  (let [f (first form)]
    (when (and (resolve f) (implemented? f))
      (list '(println "---")
            `(println "Running: " '~form)
            `(println "Result:  " ~form)))))

(defmacro print-and-do [& forms]
  (let [forms-with-println (mapcat insert-println-if-implemented forms)]
    (list* 'do forms-with-println)))

(defn single-occurrence? [sub-seq coll]
  (->> coll
       (filter (set sub-seq))
       (= sub-seq)))

(defn conj-when
  [pred coll1 coll2]
  (if (pred (first coll1)) (conj coll2 (first coll1)) coll2))

(defn get-or-default [coll f]
  (if (empty? coll) (f) (first coll)))
