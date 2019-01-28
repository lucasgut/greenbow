(ns greenbow.shared.screens.dashboard.views
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [greenbow.events]
            [greenbow.subs]
            [greenbow.shared.ui :as ui]))

(defn dashboard-view [styles]
  (let [greeting (subscribe [:get-greeting])
        companies (subscribe [:companies])]
    (fn [styles]
      [ui/view {:style (:view styles)}
       [ui/text {:style (:text styles)} @greeting]
       [ui/image {:source ui/logo-img
                  :style  (:image styles)}]
       [ui/touchable-highlight {:style {:background-color "#999" :padding 10 :border-radius 5}
                             :on-press #(ui/alert "HELLO3!")}
        [ui/text {:style {:color "white" :text-align "center" :font-weight "bold"}} "press me"]]
       [ui/scroll
       (for [company (seq @companies)]
         ^{:key company}
         [ui/text {:style {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}} (str (:name company) ": " (:score company))]
         )]])))
