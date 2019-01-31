(ns greenbow.shared.screens.dashboard.styles)

(def styles
  {:scenes    {:dashboard  {:view-dashboard { :flex 1
                                    :flex-direction "column"
                                    :margin 0
                                    :align-items "center"
                                    :backgroundColor "#00C832"}
                            :view-header { :flex-direction "row"
                                           :justifyContent "space-around"
                                           :align-items "center"
                                           :alignSelf "stretch" }
                            :text-header { :font-size 50
                                           :font-weight "100"
                                           :margin-right 20
                                           :text-align "center"}
                            :image-header { :width 100
                                            :height 100
                                            :margin-bottom 0}
                            :view-search-input { :flex-direction "row"
                                                 :justifyContent "space-around"
                                                 :alignSelf "stretch"
                                                 :align-items "center"}
                            :text-search-input { :height 40
                                                 :width 150
                                                 :margin-right 10
                                                 :borderColor "gray"
                                                 :borderWidth 1
                                                 :backgroundColor "white" }
                            :button-search-input { :color "white"
                                                   :text-align "center"
                                                   :font-weight "bold"}
                            :view-search-result-table { :flex-direction "column"
                                                        :alignSelf "stretch"
                                                        :align-items "center" }
                            :scrollview-search-result { :flex-direction "column"
                                                        :alignSelf "stretch"
                                                        :align-items "center"}
                            :view-search-result-row { :flex-direction "row"
                                                      :alignSelf "stretch"
                                                      :justifyContent "space-between"
                                                      :align-items "center"}
                            :view-search-result-column { :alignSelf "stretch"
                                                         :paddingHorizontal 10
                                                         :align-items "center"}
                            :text-search-result { :font-size 30
                                                  :font-weight "100"
                                                  :text-align "left"}
                            }
               }})
