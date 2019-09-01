(ns clj-books.brave-and-true.cap3.repl-playground)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Forms
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(+ 1 2 3)
; => 6
(str "It was the panda " "in the library " "with a dust buster")
; => "It was the panda in the library with a dust buster"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; if
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(if true
  "By Zeus's hammer!"
  "By Aquaman's trident!")
; => "By Zeus's hammer!"
(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")
; => "By Aquaman's trident!"
(if false
  "By Odin's Elbow!")
; => nil

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; do
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do ("Failure!")
      "By Aquaman's trident!"))
; => Success!
; => "By Zeus's hammer!"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; when
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(when true
  (println "Success!")
  "abra cadabra")
; => Success!
; => "abra cadabra"
(when false
  (println "Success!")
  "abra cadabra")
; => nil

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; nill, true, false, Truthiness, Equality, and Boolean Expressions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(nil? 1)
; => false
(nil? false)
; => true
(if "bears eat beets"
  "bears beets Battlestar Galactica")
; => bears beets Battlestar Galactica
(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")
; => nil is falsey
(= 1 1)
; => true
(= nil nil)
; => true
(= 1 2)
; => false
(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
; => :large_I_mean_venti
(or (= 0 1) (= "yes" "no"))
; => false
(or nil)
; => nil
(and :free_wifi :hot_coffee)
; => :hot_coffee
(and :feelin_super_cool nil false)
; => nil

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Naming Values with def
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def failed-protagonist-names ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])
failed-protagonist-names
; => ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"]
(def severity :mild)
(def error-message "OH GOD! IT'S A DISASTER! WE'RE ")
(if (= severity :mild)
  (def error-message (str error-message "MILDLY INCONVENIENCED!")) ;; never do this
  (def error-message (str error-message "DOOOOOOOOMED!"))) ;; never do this
error-message
; => "OH GOD! IT'S A DISASTER! WE'RE MILDLY INCONVENIENCED!"
(defn error-message-fn
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOOMED!")))
(error-message-fn severity)
; => "OH GOD! IT'S A DISASTER! WE'RE MILDLY INCONVENIENCED!"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Numbers
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
93
; => 93
1.2
; => 1.2
1/5
; => 1/5

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; String
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
"Lord Voldemort"
; => "Lord Voldemort"
"\"He who must not be named\""
; => "\"He who must not be named\""
"\"Great cow of Moscow!\" - Hermes Conrad"
; => "\"Great cow of Moscow!\" - Hermes Conrad"
(def chew-name "Chewbacca")
(str "\"Uggllglglglglglglglll\" - " chew-name)
; => "\"Uggllglglglglglglglll\" - Chewbacca"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Maps
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
{}
; => {}
{:first-name "Charlie"
 :last-name "McFishwich"}
; => {:first-name "Charlie", :last-name "McFishwich"}
{"string-key" +}
; => {"string-key" #function[clojure.core/+]}
{:name {:first "John"
        :middle "Jacob"
        :last "Jingleheimerschmidt"}}
; => {:name {:first "John", :middle "Jacob", :last "Jingleheimerschmidt"}}
(hash-map :a 1 :b 2)
; => {:b 2, :a 1}
(get {:a 0, :b 1} :b)
; => 1
(get {:a 0 :b {:c "ho hum"}} :b)
; => {:c "ho hum"}
(get {:a 0, :b 1} :c)
; => nil
(get {:a 0, :b 1} :c "unicorns?") ; default value
; => "unicorns?"
(get-in {:a 0 :b {:c "ho hum"}} [:b :c]) ; nested
; => "ho hum"
({:name "The Human Coffeepot"} :name)
; => "The Human Coffeepot"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Keywords
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(:a {:a 1 :b 2 :c 3})
; => 1
(get {:a 1 :b 2 :c 3} :a) ; equivalent
; => 1
(:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows") ; default value
; => "No gnome knows homes like Noah knows"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Vectors
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
[3 2 1]
; => [3 2 1]
(get [3 2 1] 0)
; => 3
(get ["a" {:name "Pugsley Winterbottom"} "c"] 1)
; => {:name "Pugsley Winterbottom"}
(vector "creepy" "full" "moon")
; => ["creepy" "full" "moon"]
(conj [1 2 3] 4)
; => [1 2 3 4]

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Lists
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
'(1 2 3 4)
; => (1 2 3 4)
(nth '(:a :b :c) 0) ; cant use get function with lists, use nth
; => :a
(nth '(:a :b :c) 2)
; => :c
(nth '(:a :b :c) 3)
; => Syntax error (IndexOutOfBoundsException) compiling at (repl_playground.clj:188:1).
(nth '(:a :b :c) 3 "default-value")
; => "default-value"
(list 1 "two" {3 4})
; => (1 "two" {3 4})
(conj '(1 2 3) 4) ; adds element to the beginning of a list
; => (4 1 2 3)
;; If you need to add elements to the beginning of a sequence or if you are writing a macro, use list, otherwise vector.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Sets
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
#{"kurt vonnegut" 20 :icicle}
; => #{20 :icicle "kurt vonnegut"}
(hash-set 1 1 2 2)
; => #{1 2}
(conj #{:a :b} :b) ; no duplicates
; => #{:b :a}
(set [3 3 3 4 4]) ; set from a list
; => #{4 3}
(contains? #{:a :b} :a)
; => true
(contains? #{:a :b} 3)
; => false
(contains? #{nil} nil)
; => true
(:a #{:a :b})
; => :a
(get #{:a :b} :a)
; => :a
(get #{:a nil} nil)
; => nil
(get #{:a :b} "kurt vonnegut")
; => nil
(get #{:a :b} "kurt vonnegut" "default")
; => "default"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Functions
;;; "It is better to have 100 functions operate on 1 data structure
;;; than 10 functions on 10 data structures" - Alan Perlis
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(+ 1 2 3 4)
; => 10
(* 1 2 3 4)
; => 24
(first [1 2 3 4])
; => 1
(or + -)
; => #function[clojure.core/+]
((or + -) 1 2 3)
; => 6
((and (= 1 1) +) 1 2 3)
; => 6
((and + (= 1 1)) 1 2 3)
; => Syntax error (ClassCastException) compiling at (repl_playground.clj:243:1).
; java.lang.Boolean cannot be cast to clojure.lang.IFn
((first [+ 0]) 1 2 3)
; => 6
(1 2 3 4) ; Numbers are not functions
; => Syntax error (ClassCastException) compiling at (repl_playground.clj:248:1).
;java.lang.Long cannot be cast to clojure.lang.IFn
("test" 1 2 3) ; Strings are not functions
; => Syntax error (ClassCastException) compiling at (repl_playground.clj:248:1).
;java.lang.Long cannot be cast to clojure.lang.IFn
;; Functions that can either take a function as an argument or return return a function are called "high-order functions"
(inc 1.1)
; => 2.1
(map inc [0 1 2 3])
; => (1 2 3 4)
;; How functions are evaluated by clojure? recursively:
(+ (inc 199) (/ 100 (- 7 2)))
(+ 200 (/ 100 (- 7 2))) ; evaluated "(inc 199)"
(+ 200 (/ 100 5)) ; evaluated (- 7 2)
(+ 200 20) ; evaluated (/ 100 5)
220
; => 220
(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GOD! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
       "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))
(too-enthusiastic "Zelda")
;=> "OH. MY. GOD! Zelda YOU ARE MOST DEFINITELY LIKE THE BEST MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"
;; The number of arguments of a function is the function "arity"
(defn no-params
  []
  "I take no parameters!")
(no-params)
; => "I take no parameters!"
(defn one-params
  [x]
  (str "I take one parameter: " x))
(one-params 1)
; => "I take one parameter: 1"
(defn two-params
  [x y]
  (str "Two Parameters! That's nothing! Pah! I will smoosh them "
       "together to spite you! " x y))
(two-params 1 2)
; => "Two Parameters! That's nothing! Pah! I will smoosh them together to spite you! 12"
;; Functions also support arity overloading
(defn multi-arity
  ([first-arg second-arg third-arg]
    (str first-arg second-arg third-arg))
  ([first-arg second-arg]
   (str first-arg second-arg))
   ([first-arg]
    (str first-arg)))
(multi-arity 1)
; => "1"
(multi-arity 1 2)
; => "12"
(multi-arity 1 2 3)
; => "123"
(defn x-chop
  "Describe they kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
    (x-chop name "karate")))
(x-chop "Kanye West" "slap")
; => "I slap chop Kanye West! Take that!"
(x-chop "Kanye West")
; => "I karate chop Kanye West! Take that!"
(defn weird-arity
  ([]
   "Destiny dressed you this morning, my friend, and now Fear is
   trying to pull off your pants. If you give up, if you give in,
   you're gonna end up naked with Fear just standing there laughing
   at your dangling unmentionables! - the Tick")
  ([number]
    (inc number))) ; Don't do this
(weird-arity)
; =>
;"Destiny dressed you this morning, my friend, and now Fear is
; trying to pull off your pants. If you give up, if you give in,
; you're gonna end up naked with Fear just standing there laughing
; at your dangling unmentionables! - the Tick"
(weird-arity 1)
; => 2
;; You can also add rest parameter
(defn codger-communication
  [whippersnappper]
  (str "Get off my lawn, " whippersnappper "!!!"))
(defn codger
  [& whippersnappper]
  (map codger-communication whippersnappper))
(codger "Billy" "Anne-Marie" "The Incredible Bulk")
; => ("Get off my lawn, Billy!!!" "Get off my lawn, Anne-Marie!!!" "Get off my lawn, The Incredible Bulk!!!")
(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))
(favorite-things "Doreen" "gum" "shoes" "kara-te")
; => "Hi, Doreen, here are my favorite things: gum, shoes, kara-te"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Destructuring
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn my-first
  [[first-thing]] ; Notice that first-thing is within a vector
  first-thing)
(my-first ["oven" "bike" "war-axe"])
; => "oven"
(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))
(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])
; Your first choice is: Marmalade
; Your second choice is: Handsome Jack
; We're ignoring the rest of your choices. Here they are in case you need to cry over them: Pigpen, Aquaman
; => nil
(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))
(announce-treasure-location {:lat 28.22 :lng 81.33})
; Treasure lat: 28.22
; Treasure lng: 81.33
; => nil
(defn announce-treasure-location-with-keys
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))
(announce-treasure-location-with-keys {:lat 28.22 :lng 81.33})
; Treasure lat: 28.22
; Treasure lng: 81.33
; => nil
(defn announce-treasure-location-with-as
  [{:keys [lat lng] :as treasure-location}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng))
  (println (str "Map: " treasure-location)))
(announce-treasure-location-with-as {:lat 28.22 :lng 81.33})
; Treasure lat: 28.22
; Treasure lng: 81.33
; Map: {:lat 28.22, :lng 81.33}
; => nil

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Function Body
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn illustrative-function
  []
  (+ 1 304)
  30
  "joe")
(illustrative-function)
; => "joe"
(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))
(number-comment 5)
; => "That number's OK, I guess"
(number-comment 7)
; => "Oh my gosh! What a big number!"

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Anonymous Functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(map (fn [name] (str "Hi , " name)) ["Darth Vader" "Mr. Magoo"])
; => ("Hi , Darth Vader" "Hi , Mr. Magoo")
((fn [x] (* x 3)) 8)
; => 24
(def my-special-multiplier (fn [x] (* x 3)))
(my-special-multiplier 12)
; => 36
#(* % 3)
(#(* % 3) 8)
; => 24
(map #(str "Hi, " %) ["Darth Vader" "Mr. Magoo"])
; => ("Hi, Darth Vader" "Hi, Mr. Magoo")
;; Function call
(* 8 3)
;; Anonymous function
#(* % 3)
;; Multiple arguments
(#(str %1 " and " %2) "cornbread" "butter beans")
; => "cornbread and butter beans"
(#(identity %&) 1 "blarg" :yip)
; => (1 "blarg" :yip)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Returning Functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))
(def inc3 (inc-maker 3))
(inc3 7)
; => 10

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Pulling it all together
;;; The shire's Next Top Model
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))
(symmetrize-body-parts asym-hobbit-body-parts)
; =>
; [{:name "head", :size 3}
; {:name "left-eye", :size 1}
; {:name "right-eye", :size 1}
; {:name "left-ear", :size 1}
; {:name "right-ear", :size 1}
; {:name "mouth", :size 1}
; {:name "nose", :size 1}
; {:name "neck", :size 2}
; {:name "left-shoulder", :size 3}
; {:name "right-shoulder", :size 3}
; {:name "right-upper-arm", :size 3}
; {:name "left-upper-arm", :size 3}
; {:name "chest", :size 10}
; {:name "back", :size 10}
; {:name "left-forearm", :size 3}
; {:name "right-forearm", :size 3}
; {:name "abdomen", :size 6}
; {:name "left-kidney", :size 1}
; {:name "right-kidney", :size 1}
; {:name "left-hand", :size 2}
; {:name "right-hand", :size 2}
; {:name "right-knee", :size 2}
; {:name "left-knee", :size 2}
; {:name "right-thigh", :size 4}
; {:name "left-thigh", :size 4}
; {:name "right-lower-leg", :size 3}
; {:name "left-lower-leg", :size 3}
; {:name "right-achilles", :size 1}
; {:name "left-achilles", :size 1}
; {:name "right-foot", :size 2}
; {:name "left-foot", :size 2}]

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; let
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(let [x 3]
  x)
; => 3
(def dalmatian-list ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)
; => ("Pongo" "Perdita")
(def x 0)
(let [x 1] x) ; New scope
; => 1
(def x 0)
(let [x (inc x)] x)
; => 1
(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])
; => ["Pongo" ("Perdita" "Puppy 1" "Puppy 2")]

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; into
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(into [] (set [:a :a]))
; => [:a]

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; loop
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(loop [iteration 0]
  (println (str "Interation " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))
; Interation 0
; Interation 1
; Interation 2
; Interation 3
; Interation 4
; Goodbye!
; => nil
(defn recursive-printer
  ([]
   (recursive-printer 0))
  ([iteration]
   (println iteration)
   (if (> iteration 3)
     (println "Goodbye!")
     (recursive-printer (inc iteration)))))
(recursive-printer)
; 0
; 1
; 2
; 3
; 4
; Goodbye!
; => nil

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Regular Expressions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(re-find #"^left-" "left-eye")
; => "left-"
(re-find #"^left-" "cleft-chin")
; => nil
(re-find #"^left-" "wongleblart")
; => nil
(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
(matching-part {:name "left-eye" :size 1})
; => {:name "right-eye", :size 1}
(matching-part {:name "head" :size 3})
; => {:name "head", :size 3}

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Reduce
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(reduce + [1 2 3 4])
; => 10
(reduce + 15 [1 2 3 4])
; => 25
(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))
(my-reduce + [1 2 3 4])
; => 10
(defn better-symmetrize-body-parts
   "Expects a seq of maps that have a :name and :size"
  [assym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          assym-body-parts))
(better-symmetrize-body-parts asym-hobbit-body-parts)
; =>
;[{:name "head", :size 3}
; {:name "left-eye", :size 1}
; {:name "right-eye", :size 1}
; {:name "left-ear", :size 1}
; {:name "right-ear", :size 1}
; {:name "mouth", :size 1}
; {:name "nose", :size 1}
; {:name "neck", :size 2}
; {:name "left-shoulder", :size 3}
; {:name "right-shoulder", :size 3}
; {:name "right-upper-arm", :size 3}
; {:name "left-upper-arm", :size 3}
; {:name "chest", :size 10}
; {:name "back", :size 10}
; {:name "left-forearm", :size 3}
; {:name "right-forearm", :size 3}
; {:name "abdomen", :size 6}
; {:name "left-kidney", :size 1}
; {:name "right-kidney", :size 1}
; {:name "left-hand", :size 2}
; {:name "right-hand", :size 2}
; {:name "right-knee", :size 2}
; {:name "left-knee", :size 2}
; {:name "right-thigh", :size 4}
; {:name "left-thigh", :size 4}
; {:name "right-lower-leg", :size 3}
; {:name "left-lower-leg", :size 3}
; {:name "right-achilles", :size 1}
; {:name "left-achilles", :size 1}
; {:name "right-foot", :size 2}
; {:name "left-foot", :size 2}]

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Hobbit Violence
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
    (loop [[part & remaining] sym-parts
            accumulated-size (:size part)]
       (if (> accumulated-size target)
         part
         (recur remaining (+ accumulated-size (:size (first remaining))))))))
(hit asym-hobbit-body-parts)
; => {:name "left-hand", :size 2}
(hit asym-hobbit-body-parts)
; => {:name "back", :size 10}
(hit asym-hobbit-body-parts)
; => {:name "chest", :size 10}
