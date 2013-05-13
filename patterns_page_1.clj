;; 'variables'
;; --------------
(def var-name "string value")
(def var-name 2) ;; Integer value
(def var-name 2.0) ;; Float value
(def var-name 1/2) ;; Ratio value

;; define a vector
(def some-vector [1 2 3])
;; access a vector
(first some-vector)  ;; 1
(last some-vector)   ;; 3
(nth some-vector 1)  ;; 2

;; , (comma) are treated as whitespace
(def some-vector [1, 2,,, 3]) ;; [1 2 3]

;; changing a vector
(cons :a [2 3]) ;; [:a 2 3]
(conj [1 2] :c) ;; [1 2 :c]
(assoc [1 2] 0 :a) ;; [:a 2]

;; define a map
(def some-map {:key "value"})
(def some-map-2 {2 [:val1 "val2"]})
;; accessing a map
(get some-map :key) ;; "value"
(:key some-map)     ;; "value"
(some-map :key)     ;; "value"
(get some-map :missing-key "default") ;; "default"
(keys some-map) ;; [:key]
(vals some-map) ;; ["value"]

;; changing a map
(assoc some-map :other-key "other value") ;; {:key "value", :other-key "other value"}


;; functions
;; --------------

;; no infix for arithemtic functions
(+ 1 2)   ;; 3
(+ 1 2 3) ;; 6

;; any function is a first class citizens
;; including + - / ...
(def funny-plus +)
(funny-plus 1 2)

;; you can also destroy stuff
;; (def - +)
;; (- 1 2) ;; 3

;; defining functions
;; you can use almost any character
;; just don't start with / ; @ \
(defn fn-name [arg1 arg2]
  (+ arg1 arg2))

(fn-name 2 3) ;; 5

;; printing
(println "some" "more" "test" 3) ;; prints: some more test 3

;; define local vars
(defn authorized? [user-id]
  (let [user "user_name" ;; here could be (db-get-user user-id)
        result true] ;; define as many variables as you like
    result)) ;; return result

;; destructuring vectors
(defn get-element [[x y]]
  (nth (nth [[0 1]
             [2 3]]
            y)
       x))
(def pos [1 1])
(get-element pos) ;; 3

;; destructuring maps
(defn elect-user [{user-name :name}]
  (str user-name " for president"))
(elect-user {:id 2, :name "Itchy"}) ;; "Itchy for president"




;; data transformation
;; --------------
;; map
(map inc [1 2 3])       ;; [2 3 4]
(map (fn [x] (inc x))
     [1 2 3])           ;; [2 3 4]

;; filter
(filter even? [1 2 3 4]) ;; [2 4]
(filter (fn [x] (even? x))
        [1 2 3 4]) ;; [2 4]

;; reduce
(reduce + [1 2 3]) ;; 6
(reduce (fn [accumulator x] (+ accumulator x))
        [1 2 3]) ;; 6

;; list comprehension
(for [user ["Itchy" "Scratchy"]]
  (str user " for president!"))
;; ["Itchy for president!" "Scratchy for president!"]

(for [x [0 1]
      y [0 1]]
    [x y]) ;; [[0 0] [0 1] [1 0] [1 1]]



;; flow controll
;; --------------

;; if
(if (= 1 1)
  (println "true case")
  (println "false case")) ;; 2nd is optional

;; code block
;; --------------
(if true
  (do
    (println "printing is a side efect")
    "value") ;; do many things if true
  "false")

