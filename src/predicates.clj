(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [award? (fn [award] (has-award? book award))]
    (every? award? awards)))

(defn my-some [pred a-seq]
  (let [true-values (filter pred a-seq)]
    (if (not (empty? true-values))
    (pred (first true-values))
    false)))

(defn my-every? [pred a-seq]
  (== (count a-seq) (count (filter pred a-seq))))

(defn prime? [n]
  (let [divides? (fn [x] (== 0 (mod n x)))]
    (not (some divides? (range 2 n)))))
;^^
