(ns greenbow.company-search
  (:require
    [clojure.string :as s]))

;; Filter the specified list of companies by name and sort by score in descending order
(defn find-by-name [companies search-string]
  (sort-by :score #(> %1 %2)
           (filter #(.contains (s/lower-case (:name %)) (s/lower-case search-string)) companies)))

(defn- find-establishment-keywords-filter [keyword search-string]
  (let [search-string-length (count search-string)]
    (if (= search-string-length 0)
      false
      (if (> search-string-length 1)
        (.contains (s/lower-case keyword) (s/lower-case search-string))
        (.startsWith (s/lower-case keyword) (s/lower-case search-string))))))

;; Filter the specified list of establishment keywords
(defn find-establishment-keywords [establishment-keywords search-string]
  (filter #(find-establishment-keywords-filter % search-string) establishment-keywords))
