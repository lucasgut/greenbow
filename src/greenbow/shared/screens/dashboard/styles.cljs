(ns greenbow.shared.screens.dashboard.styles)

(def styles
  {:app       {:position "absolute"
               :top      0
               :left     0
               :bottom   0
               :right    0}
   :scenes    {:dashboard  {:view {:flex 1 :flex-direction "column" :margin 40 :align-items "center"}
                            :text {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}
                            :image {:width 80 :height 80 :margin-bottom 30}
                            :company-name-textinput {:height 40 :borderColor "gray" :borderWidth 1}
                            :result-text {:font-size 30 :font-weight "100" :margin-bottom 20 :text-align "center"}
                            }
               }})
