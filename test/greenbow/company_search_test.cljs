(ns greenbow.company-search-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [greenbow.company-search :as company-search]))

(deftest get-establishment-keywords-test
  (testing "Get all establishment keywords matching a specific search string."
    (is (= (company-search/get-establishment-keywords ["beer" "coffee" "tea"] "ee")
           ["beer" "coffee"]))))
