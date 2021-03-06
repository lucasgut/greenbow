(ns greenbow.shared.screens.dashboard.styles)

(def styles
  {:scenes    {:dashboard  {:view-dashboard { :flex 1
                                              :flex-direction "column"
                                              :margin 0
                                              :justifyContent "flex-start"
                                              :align-items "stretch"
                                              :backgroundColor "#00C832"}
                            :view-header { :flex-direction "row"
                                           :justifyContent "space-around"
                                           :height 100
                                           :align-items "center" }
                            :text-header { :font-size 50
                                           :font-weight "100"
                                           :margin-right 20
                                           :text-align "center"}
                            :image-header { :width 100
                                            :height 80
                                            :margin-bottom 0}
                            :view-search-input { :flex-direction "row"
                                                 :justifyContent "space-around"
                                                 :height 50
                                                 :paddingHorizontal 20
                                                 :align-items "center"}
                            :autocomplete-search-input-container { :height 40
                                                                   :width 200
                                                                   :margin-right 10
                                                                   :borderColor "gray"
                                                                   :borderWidth 1
                                                                   :backgroundColor "white" }
                            :autocomplete-search-list-container { :zIndex 1
                                                                  :position "absolute" }
                            :autocomplete-search-list-highlight { :background-color "#EEE"
                                                                  :padding 2 }
                            :autocomplete-search-list-text { :font-size 18 }
                            :button-search-input-highlight { :background-color "#999"
                                                             :padding 10
                                                             :border-radius 5}
                            :button-search-input-text { :color "white"
                                                        :text-align "center"
                                                        :font-weight "bold"}
                            :view-search-result-table { :flex 1
                                                        :flex-direction "column"
                                                        :align-items "stretch"}
                            :scrollview-search-result { :flex-direction "column"
                                                        :align-items "stretch"}
                            :view-search-result-row { :flex-direction "row"
                                                      :justifyContent "space-between"
                                                      :paddingHorizontal 20
                                                      :align-items "stretch" }
                            :view-search-result-column { :paddingHorizontal 10
                                                         :align-items "center"}
                            :text-search-result { :font-size 30
                                                  :font-weight "100"
                                                  :text-align "left"}
                            }
               }})
