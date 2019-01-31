(ns greenbow.shared.screens.dashboard.views
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [greenbow.events :as events]
            [greenbow.subs]
            [greenbow.shared.ui :as ui]))

(defn dashboard-view [styles]
  (let [greeting (subscribe [:get-greeting])
        companies (subscribe [:companies])
        company-name (subscribe [:company-name])]
    (fn [styles]
      [ui/view {:style (:view-dashboard styles)}
       [ui/view {:style (:view-header styles)}
        [ui/text {:style (:text-header styles)} @greeting]
        [ui/image {:source ui/logo-img
                   :style  (:image-header styles)}]]
       [ui/view {:style (:view-search-input styles)}
        [ui/input {:style (:text-search-input styles) :onChangeText #(dispatch [::events/set-company-name %]) :value @company-name}]
        [ui/touchable-highlight {:style {:background-color "#999" :padding 10 :border-radius 5}
                                 :on-press #(ui/alert @company-name)}
         [ui/text {:style (:button-search-input styles)} "Search"]]]
       [ui/view {:style (:view-search-result-table styles)}
        [ui/scroll {:contentContainerStyle (:scrollview-search-result styles)}
         (for [company (seq @companies)]
           ^{:key company}
           [ui/view {:style (:view-search-result-row styles)}
            [ui/view {:style (:view-search-result-column styles)}
             [ui/text {:style (:text-search-result styles)} (:name company)]]
            [ui/view {:style (:view-search-result-column styles)}
             [ui/text {:style (:text-search-result styles)} (:score company)]]]
           )]]])))
