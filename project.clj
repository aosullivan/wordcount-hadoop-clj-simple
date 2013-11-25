(defproject wordcount-hadoop-clj "0.1.0-SNAPSHOT"  
  :description "Clojure Hadoop MR Job"
  :url "https://github.com/aosullivan/wordcount-hadoop-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :repositories [["GM Repositories" "http://gmrepo.gslb.db.com:8481/nexus-webapp/content/groups/gmrepositories/"]
                 ["cloudera" "http://http://gmrepo.gslb.db.com:8481/nexus-webapp/content/repositories/cloudera/"]]
  :mirrors {"central" {:name "gmrepo-proxy" :url "http://gmrepo.gslb.db.com:8481/nexus-webapp/content/groups/gmrepositories/"}
            "clojars" {:name "clojars-proxy" :url "http://gmrepo.gslb.db.com:8481/nexus-webapp/content/repositories/clojars/"}}
  :local-repo "c:/m2/repository"  
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/core.typed "0.2.19"] 
                 [org.apache.hadoop/hadoop-core "0.20.2-cdh3u4"]]
  ;:main main has to be compiled last or else the hard dependency on map & reduce won't get resolved after a clean 
  :aot [wordcounthadoopclj.map  
        wordcounthadoopclj.reduce
        wordcounthadoopclj.core]
)
