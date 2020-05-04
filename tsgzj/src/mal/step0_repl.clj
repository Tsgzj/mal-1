(ns mal.step0_repl
  (:gen-class))

(defn READ [str] str)

(defn EVAL [exp] exp)

(defn PRINT [res] res)

(defn rep [str]
   (-> str
       READ
       EVAL
       PRINT))

;; Added flush to work avoid store in the buffer
;; https://clojuredocs.org/clojure.core/read-line
(defn repl []
    (do
      (print "user> ")
      (flush)
      (let [input (read-line)]
        (when (not (clojure.string/blank? input))
          (println (rep input))
          (recur)))))

(defn -main [& args]
  (repl))
