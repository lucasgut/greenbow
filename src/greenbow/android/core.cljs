(ns greenbow.android.core
  (:require [reagent.core :as r :refer [atom]]
            [re-frame.core :refer [subscribe dispatch dispatch-sync]]
            [greenbow.events]
            [greenbow.subs]
            [greenbow.shared.ui :as ui]
            [greenbow.shared.screens.dashboard.views :refer [dashboard-view]]
            [greenbow.shared.screens.dashboard.styles :as s]))

(defn app-root []
  [dashboard-view (get-in s/styles [:scenes :dashboard])])

(defn init []
      (dispatch-sync [:initialize-db])
      (.registerComponent ui/app-registry "greenbow" #(r/reactify-component app-root)))
