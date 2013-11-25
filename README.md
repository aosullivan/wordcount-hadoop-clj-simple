# wordcount-hadoop-clj

A Clojure library designed to execute WordCount as a Hadoop Map Reduce job

## Usage

lein uberjar - will create a jar with the clojure dist, will need this when we want to run on the cluster
lein run - will execute main then exit (as defined in project.clj), cool. I don't think this builds a jar so ok only for loca

- Although lab2 has been upgraded to cdh4, things still seem to work - Karmasphere, plus the hadoop jar version
- Probably should move this whole effort to the VM

## License

Copyright Adrian O'Sullivan 2013 

Distributed under the Eclipse Public License, the same as Clojure.
