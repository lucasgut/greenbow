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
      [ui/view {:style (:view styles)}
       [ui/text {:style (:text styles)} @greeting]
       [ui/image {:source ui/logo-img
                  :style  (:image styles)}]
       [ui/touchable-highlight {:style {:background-color "#999" :padding 10 :border-radius 5}
                             :on-press #(ui/alert @company-name)}
        [ui/text {:style {:color "white" :text-align "center" :font-weight "bold"}} "Search"]]
       [ui/input {:style {:height 40 :borderColor "gray" :borderWidth 1} :onChangeText #(dispatch [::events/set-company-name %]) :value @company-name}]
       [ui/scroll
       (for [company (seq @companies)]
         ^{:key company}
         [ui/text {:style (:result-text styles)} (str (:name company) ": " (:score company))]
         )]])))
