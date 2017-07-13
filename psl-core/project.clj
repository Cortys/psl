(defproject org.linqs/psl-core "2.1.0-SNAPSHOT"
  :description "Core module of the PSL software from the LINQS research group."
  :dependencies [[edu.emory.mathcs/parallelcolt "0.9.4"]
                 [edu.emory.mathcs/jplasma "1.2"]
                 [log4j "1.2.17"]
                 [org.slf4j/slf4j-api "1.7.21"]
                 [org.slf4j/slf4j-log4j12 "1.7.21"]
                 [com.google.guava/guava "20.0"]
                 [org.apache.commons/commons-lang3 "3.5"]
                 [org.apache.commons/commons-collections4 "4.1"]
                 [commons-configuration "1.6"]
                 [com.h2database/h2 "1.4.192"]
                 [com.healthmarketscience.sqlbuilder/sqlbuilder
                  "2.1.5"]
                 [joda-time "2.9.4"]]

  :repositories {"psl-releases" "https://linqs-data.soe.ucsc.edu/maven/repositories/psl-releases"
                 "psl-thirdparty" "https://linqs-data.soe.ucsc.edu/maven/repositories/psl-thirdparty"}

  :java-source-paths ["src/main/java"])
