(ns blockduck.collection)

(defn diff [group-1 group-2] (remove #(some #{%} group-2) group-1))
