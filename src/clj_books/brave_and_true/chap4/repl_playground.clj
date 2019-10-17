(ns clj-books.brave-and-true.chap4.repl-playground)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; map
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn titleize
  [topic]
  (str topic " for the Brave and True"))
(map titleize ["Hamsters" "Ragnarok"])
; => ("Hamsters for the Brave and True" "Ragnarok for the Brave and True")
(map titleize '("Empathy" "Decorating"))
; => ("Empathy for the Brave and True" "Decorating for the Brave and True")
(map titleize #{"Elbows" "Soap Carving"})
; => ("Elbows for the Brave and True" "Soap Carving for the Brave and True")
(map #(titleize (second %)) {:uncomfortable-thing "Winking"})
; => ("Winking for the Brave and True")

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; seq
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(seq '(1 2 3))
; => (1 2 3)
(seq [1 2 3])
; => (1 2 3)
(seq #{1 2 3})
; => (1 2 3)
(seq {:name "Bill Compton" :occupation "Dead mopey guy"})
; => ([:name "Bill Compton"] [:occupation "Dead mopey guy"])
(seq [{:name "Bill Compton" :occupation "Dead mopey guy"}
      {:name "Mamamia"      :occupation "Cook"}])
; => ({:name "Bill Compton", :occupation "Dead mopey guy"} {:name "Mamamia", :occupation "Cook"})
(into {} (seq {:a 1 :b 2 :c 3})) ; seq transform in a list of vectors, and we can just call into to transform it back
; => {:a 1, :b 2, :c 3}

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; map again
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(map inc [1 2 3])
; => (2 3 4)


