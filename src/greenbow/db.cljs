(ns greenbow.db
  (:require [clojure.spec.alpha :as s]))

;; spec of app-db
(s/def ::greeting string?)
(s/def ::companies map?)
(s/def ::company-name string?)
(s/def ::app-db
       (s/keys :req-un [::greeting]))

;; initial state of app-db
(def app-db {
              :greeting "Greenbow"
              :companies '(
                           { :name "Starbucks"
                             :score 56.3
                             :type :cafe
                             }
                           { :name "Costa Coffee"
                             :score 65.7
                             :type :cafe
                             }
                           { :name "Pizza Express"
                             :score 65.3
                             :type :restaurant
                             }
                           { :name "Prezzo"
                             :score 75.4
                             :type :restaurant
                             }
                           { :name "Mod Pizza"
                             :score 88.4
                             :type :restaurant
                             }
                           { :name "Pizza Hut"
                             :score 48.4
                             :type :restaurant
                             }
                           { :name "Tesco"
                             :score 68.4
                             :type :groceries
                             }
                           { :name "Morissons"
                             :score 78.4
                             :type :groceries
                             }
                           { :name "Sainsbury"
                             :score 73.2
                             :type :groceries
                             }
                           { :name "Iceland"
                             :score 42.1
                             :type :groceries
                             }
                           { :name "Aldi"
                             :score 58.4
                             :type :groceries
                             }
                           { :name "Lidl"
                             :score 66.2
                             :type :groceries
                             }
                           )
              :company-name ""
              })
