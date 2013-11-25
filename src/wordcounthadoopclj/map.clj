(ns wordcounthadoopclj.map
  (:gen-class  
   :extends org.apache.hadoop.mapreduce.Mapper)
  (:import [org.apache.hadoop.io IntWritable]
					 [org.apache.hadoop.io Text])
  (:use [clojure.string :only [split]])
  )

(defn writeout [context text word]
   (.set text word )
   (.write context text (IntWritable. 1))
  )

(defn tokenize [line] 
  (split line #" "))

(defn -map [_ key value context] 

  (let [text (Text.)  
        line (.toString value)]    
    (doseq [word (tokenize line)] 
      (writeout context text word)) 
    )
  
  )