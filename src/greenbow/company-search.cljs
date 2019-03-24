(ns greenbow.company-search
  (:require
    [clojure.string :as s]))

;; Filter the specified list of companies by name and sort by score in descending order
(defn find-by-name [companies search-string]
  (sort-by :score #(> %1 %2)
           (filter #(.contains (s/lower-case (:name %)) (s/lower-case search-string)) companies)))

;; Filter the specified list of companies by establishment
(defn find-by-establishment [companies establishment]
  (sort-by :score #(> %1 %2)
           (filter #(= (:type %) establishment) companies)))

;; Get the establishment for the specified keyword
(defn get-establishment-by-keyword [establishments key_word]
  (key (first (filter (fn [k v] (some #(= key_word %) v)) establishments))))

(defn- find-establishment-keywords-filter [key_word search-string]
  (let [search-string-length (count search-string)]
    (if (= search-string-length 0)
      false
      (if (> search-string-length 1)
        (.contains (s/lower-case key_word) (s/lower-case search-string))
        (.startsWith (s/lower-case key_word) (s/lower-case search-string))))))

;; Filter the specified list of establishment keywords
(defn find-establishment-keywords [establishment-keywords search-string]
  (filter #(find-establishment-keywords-filter % search-string) establishment-keywords))
