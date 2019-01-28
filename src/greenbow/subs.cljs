(ns greenbow.subs
  (:require [re-frame.core :refer [reg-sub]]))

(reg-sub
  :get-greeting
  (fn [db _]
    (:greeting db)))

(reg-sub
  :companies
  (fn [db _]
    (:companies db)))

(reg-sub
  :company-name
  (fn [db _]
    (:company-name db)))
