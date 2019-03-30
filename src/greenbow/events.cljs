(ns greenbow.events
  (:require
    [re-frame.core :refer [reg-event-db after]]
    [clojure.spec.alpha :as spec]
    [greenbow.shared.ui :as ui]
    [greenbow.company-search :as company-search]
    [greenbow.db :as db :refer [app-db]]))

;; -- Interceptors ------------------------------------------------------------
;;
;; See https://github.com/Day8/re-frame/blob/master/docs/Interceptors.md
;;
(defn check-and-throw
  "Throw an exception if db doesn't have a valid spec."
  [spec db [event]]
  (when-not (spec/valid? spec db)
    (let [explain-data (spec/explain-data spec db)]
      ;;       (throw (ex-info (str "Spec check after " event " failed: " explain-data) explain-data)))))
      (throw (ex-info "Greenbow" explain-data)))))

(def validate-spec
  (if goog.DEBUG
    (after (partial check-and-throw ::db/app-db))
    []))

;; -- Handlers --------------------------------------------------------------

(reg-event-db
  :initialize-db
  validate-spec
  (fn [_ _]
    app-db))

(reg-event-db
  :set-greeting
  validate-spec
  (fn [db [_ value]]
    (assoc db :greeting value)))

(reg-event-db
  ::set-company-name
  validate-spec
  (fn [db [_ value]]
    (assoc db :company-name value)))

(reg-event-db
  ::search-company
  (fn [db [_ value]]
    (assoc db :search-result (seq (company-search/find-by-name (:companies db) value)))))

;; Search companies by establishment keyword
(reg-event-db
  ::select-establishment-for-keyword
  (fn [db [_ key_word]]
    (assoc db :company-name (.toString (company-search/get-establishment-by-keyword db/establishments key_word)))))
