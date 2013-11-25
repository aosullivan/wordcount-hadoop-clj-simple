(ns wordcounthadoopclj.core 
  (:gen-class) ;Hadoop requires a .class file - see :aot in project.clj 
  (:import [org.apache.hadoop.conf Configuration]
           [org.apache.hadoop.fs FileSystem Path]
           [org.apache.hadoop.mapreduce Job]
           [org.apache.hadoop.io Text IntWritable]
           [org.apache.hadoop.mapreduce.lib.input TextInputFormat]
           [org.apache.hadoop.mapreduce.lib.output TextOutputFormat]
           [org.apache.hadoop.mapreduce.lib.input FileInputFormat]
           [org.apache.hadoop.mapreduce.lib.output FileOutputFormat]
           [wordcounthadoopclj.map]
           [wordcounthadoopclj.reduce]
           ))

(defn inputFile [args] (or (nth args 0) "hamlet111.txt") )
(defn outputFolder [args] (or (nth args 1)  "target/output"))

;Hadoop requires a static void main
(defn  -main [& args] 
  
  (println "Clojure Hadoop MapReduce: params are <input file> <output folder>")
  (println "Input filename: " (inputFile args) ) 
  (println "Output folder: " (outputFolder args) )
  
  (let [config (Configuration.)
        fs (FileSystem/get config)
        p (Path. (outputFolder args))]
    (.delete fs p true)
   )
  
  (let [config (Configuration.)
        job (Job. config "wordcount")]
    (.setOutputKeyClass job Text)
    (.setOutputValueClass job IntWritable)
    (.setMapperClass job wordcounthadoopclj.map)  
    (.setReducerClass job wordcounthadoopclj.reduce)
    (.setInputFormatClass job TextInputFormat)
    (.setOutputFormatClass job TextOutputFormat)
    (FileInputFormat/addInputPath job (Path. (inputFile args))  )
    (FileOutputFormat/setOutputPath job (Path. (outputFolder args))  )
    (.waitForCompletion job true)
        
   )
  
  
    
)
  
;  (map #(println %) args)  
; (map #(+ % 10) [1 2 3 4 5])
; (filter #(> % 3) [1 2 3 4 5])
; #(something) is an anonymous function.  % is the parameter which the function will pass into it
; %1 is first param, %2 is second param


; (.setOutputFormatClass job (Class/forName (.getName TextOutputFormat)))    