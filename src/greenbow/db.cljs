(ns greenbow.db
  (:require [clojure.spec.alpha :as s]))

;; spec of app-db
(s/def ::greeting string?)
(s/def ::companies map?)
(s/def ::company-name string?)
(s/def ::search-result (s/coll-of map? :kind vector?))
(s/def ::app-db
       (s/keys :req-un [::greeting]))

;; A map of establishments with a list of search keywords which map to each establishments
(def establishments {
                      :Supermarket ["supermarket", "grocery store"]
                      :ClothingStore ["clothing store", "footwear", "accessories", "department store"]
                      :OutdoorsStore ["outdoors store"]
                      :Building ["home improvement", "DIY", "building supplies", "hardware store", "gardening"]
                      :Furniture ["furniture store", "homeware"]
                      :Jewellery ["jewellery and watches"]
                      :Health ["pharmacy", "personal care", "health", "medicines", "drugs"]
                      :Media ["books", "music"]
                      :Bar ["bar", "nightclub", "pub drink"]
                      :OffLicense ["wine store", "off-license"]
                      :Cafe ["cafe", "coffee shop", "tea shop"]
                      :TakeAway ["take away" "chippie", "fish and chips", "kebab"]
                      :Restaurant ["restaurant", "pub food"]
                      :FastFood ["fast-food restaurant"]
                      :Entertainment ["cinema", "theatre", "opera", "standup comedy"]
                      :Financial ["bank", "currency exchange"]
                      :Petrol ["petrol", "gas", "filling station"]
                      })

;; initial state of app-db
(def app-db {
              :greeting "Greenbow"
              :establishment-keywords (flatten (vals establishments))
              :companies '(
                            { :name "Starbucks"
                              :score 56.3
                              :type :Cafe }
                            { :name "Costa Coffee"
                              :score 65.7
                              :type :Cafe }
                            { :name "Pizza Express"
                              :score 65.3
                              :type :Restaurant }
                            { :name "Prezzo"
                              :score 75.4
                              :type :Restaurant }
                            { :name "Mod Pizza"
                              :score 88.4
                              :type :Restaurant }
                            { :name "Pizza Hut"
                              :score 48.4
                              :type :FastFood }
                            { :name "Tesco"
                              :score 68.4
                              :type :Supermarket }
                            { :name "Morissons"
                              :score 78.4
                              :type :Supermarket }
                            { :name "Sainsbury"
                              :score 73.2
                              :type :Supermarket }
                            { :name "Iceland"
                              :score 42.1
                              :type :Supermarket }
                            { :name "Aldi"
                              :score 58.4
                              :type :Supermarket }
                            { :name "Lidl"
                              :score 66.2
                              :type :Supermarket }
                            )
              :company-name ""
              :search-result []
              })
