(ns greenbow.company-search
  (:require
    [clojure.string :as s]))

;; Filter the specified list of companies by name and sort by score in descending order
(defn find-by-name [companies search-string]
  (sort-by :score #(> %1 %2)
           (filter #(.contains (s/lower-case (:name %)) (s/lower-case search-string)) companies)))

