(ns greenbow.company-search
  (:require
    [clojure.string :as s]))

;; Get the companies whose name contains the specified search string and sort the result by score
(defn- find-by-name [companies search-string]
  (filter #(.contains (s/lower-case (:name %)) (s/lower-case search-string)) companies))

;; Get the companies with the specified establishment type and sort the result by score
;; (find-by-establishment [{ :name "MyCafe" :score 56.3 :type :Cafe } { :name "MyRestaurant" :score 65.3 :type :Restaurant }] :Cafe) => {:name "MyCafe", :score 56.3, :type :Cafe}
(defn- find-by-establishment [companies establishment]
  (filter #(= (:type %) establishment) companies))

;; Get the companies by name or, if it starts with colon, by establishment. Sort the result by score
;; (find-by-name-or-establishment [{ :name "MyCafe" :score 56.3 :type :Cafe } { :name "MyRestaurant" :score 65.3 :type :Restaurant }] ":Cafe") => {:name "MyCafe", :score 56.3, :type :Cafe}
(defn find-by-name-or-establishment [companies search-string]
  (sort-by :score #(> %1 %2)
           (if (s/starts-with? search-string ":")
             (find-by-establishment companies (keyword (subs search-string 1)))    ;; Remove preceding colon to create a keyword
             (find-by-name companies search-string))))

;; Get the establishment for the specified keyword
;; (get-establishment-by-keyword { :bar ["beer" "coffee"] :cafe ["tea" "coffee"] } "coffee") => :bar
(defn get-establishment-by-keyword [establishments key_word]
  (key (first (filter (fn [[k v]] (some (partial = key_word) v)) establishments))))

(defn- get-establishment-keywords-filter [key_word search-string]
  (let [search-string-length (count search-string)]
    (if (= search-string-length 0)
      false
      (if (> search-string-length 1)
        (s/includes? (s/lower-case key_word) (s/lower-case search-string))
        (s/starts-with? (s/lower-case key_word) (s/lower-case search-string))))))

;; Get establishment keywords which match the specified search string
;; if search string only 1 letter, find keywords starting with this letter. Otherwise find keywords which contain the specified search string
;; (get-establishment-keywords ["beer" "coffee" "tea"] "ee") => ["beer" "coffee"]
(defn get-establishment-keywords [establishment-keywords search-string]
  (filter #(get-establishment-keywords-filter % search-string) establishment-keywords))
