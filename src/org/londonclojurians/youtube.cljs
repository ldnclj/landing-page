;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; YouTube Videos for the London Clojurians community
;;
;; Video ids and titles scraped from the London Clojurians community YouTube channel.
;; A quick hack to skip calling the YouTube API each time.
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns org.londonclojurians.youtube)



(def community-video-ids
  [{:id    "_6qVfFkBdWI"
    :title "Performance testing with JMH Clojure & Java Microbenchmark Harness"}
   {:id    "aJbdTP5hL0U"
    :title "Logic programming with clara-rules"}
   {:id    "-5SrIUK6k5g "
    :title "Datalevin - simple durable Datalog database to embed in Clojure stateful apps"}
   {:id    "iyHvwkc6Wis "
    :title "Clojure and gRPC - overcoming FOMO - Fear of Missing Out"}
   {:id    "0V_F9Ko_Ic8"
    :title "Discoverable Hypermedia-Driven RESTful Web Services in Clojure"}
   {:id    "IvTDzKVL58Y"
    :title "Dark CIDER - lesser known features for Clojure development"}
   {:id    "pgNp4Lk3gf0"
    :title "babashka and sci - Clojure command line tool internals"}
   {:id    "bQDkuF6-py4"
    :title "Designing Clojure with Malli"}
   {:id    "P1149dWnl3k"
    :title "μ/log and the next 100 logging systems"}
   {:id    "ttocpHaPmzU"
    :title "Multiplayer Online Game in Clojure - Attack of the Clones"}
   {:id    "gIoadGfm5T8"
    :title "REPL Driven Development, Clojure's Superpower"}
   {:id    "UCEzBNh9ufs"
    :title "Dynamic Notebooks and Literate Programming"}
   {:id    "qvZIY-46ML0"
    :title "Bringing PHP back with GraalVM and PCP"}
   {:id    "wp93e0-xPvI"
    :title "Data Oriented Programming in Practice"}
   {:id    "zoOXCaZ3M2Y"
    :title "Learn rule engines with minikusari"}
   {:id    "ujuumP_MQx0"
    :title "Distributed Task Management with Kafka and Clojure"}
   {:id    "_7sncBhluXI"
    :title "What's So Hard About Writing A Compiler, Anyway? Oh"}
   {:id    "JWa4NhjWNHQ"
    :title "Building a RESTful Web API in Clojure - a new approach"}
   ])
