(ns wordcounthadoopclj.reduce
  (:gen-class
   :extends org.apache.hadoop.mapreduce.Reducer)
  (:import [org.apache.hadoop.io IntWritable])
  )

(defn -reduce [_ key values context] 
  
   ;count the values for this key
   (let [i (ref 0)
         output (IntWritable.)]
	     (doseq [val values] (dosync (alter i inc))) 
	     (.set output (deref i) )  
	     (.write context key output)
     )
   
  )