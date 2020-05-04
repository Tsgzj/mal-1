(ns mal.core
  (:gen-class))

(defn READ [str] str)

(defn EVAL [exp] exp)

(defn PRINT [res] res)

(defn rep [str]
   (-> str
       READ
       EVAL
       PRINT))

(defn repl []
    (do
      (print "user> ")
      (let [input (read-line)]
        (when (not (= "" input))
          (println (rep input))
          (recur)))))

(defn -main [& args]
  (repl))
