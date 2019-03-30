(ns greenbow.shared.screens.dashboard.views
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [greenbow.events :as events]
            [greenbow.subs]
            [greenbow.shared.ui :as ui]
            [greenbow.company-search :as company-search]))

(defn dashboard-view [styles]
  (let [greeting (subscribe [:get-greeting])
        search-result (subscribe [:search-result])
        company-name (subscribe [:company-name])
        search-keywords (subscribe [:search-keywords])]
    (fn [styles]
      [ui/view {:style (:view-dashboard styles)}
       [ui/view {:style (:view-header styles)}
        [ui/text {:style (:text-header styles)} @greeting]
        [ui/image {:source ui/logo-img
                   :style  (:image-header styles)}]]
       [ui/view {:style (:view-search-input styles)}
        [ui/autocomplete-input { :inputContainerStyle (:autocomplete-search-input-container styles)
                                 :listStyle (:autocomplete-search-list-container styles)
                                 :defaultValue @company-name
                                 :placeholder "Company name or type"
                                 :data (company-search/get-establishment-keywords @search-keywords @company-name)
                                 :onChangeText #(dispatch [::events/set-company-name %])
                                 :renderItem (fn [item] (r/as-element [ui/touchable-opacity {:style (:autocomplete-search-list-highlight styles)
                                                                                   :on-press #(dispatch [::events/select-establishment-for-keyword item])}
                                                             [ui/text {:style (:autocomplete-search-list-text styles)} item]]))}]
        [ui/touchable-highlight {:style (:button-search-input-highlight styles)
                                 :on-press #(dispatch [::events/search-company @company-name])}
         [ui/text {:style (:button-search-input-text styles)} "Search"]]]
       [ui/view {:style (:view-search-result-table styles)}
        [ui/scroll {:contentContainerStyle (:scrollview-search-result styles)}
         (for [company @search-result]
           ^{:key company}
           [ui/view {:style (:view-search-result-row styles)}
            [ui/view {:style (:view-search-result-column styles)}
             [ui/text {:style (:text-search-result styles)} (:name company)]]
            [ui/view {:style (:view-search-result-column styles)}
             [ui/text {:style (:text-search-result styles)} (:score company)]]]
           )]]])))
