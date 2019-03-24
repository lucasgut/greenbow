(ns greenbow.shared.ui
  (:require [reagent.core :as r]
            [react-native-autocomplete-input]
            ))

(def ReactNative (js/require "react-native"))
(def app-registry (.-AppRegistry ReactNative))

;; Basic views

(def text (r/adapt-react-class (.-Text ReactNative)))
(def view (r/adapt-react-class (.-View ReactNative)))
(def scroll (r/adapt-react-class (.-ScrollView ReactNative)))
(def image (r/adapt-react-class (.-Image ReactNative)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight ReactNative)))
(def touchable-opacity (r/adapt-react-class (.-TouchableOpacity ReactNative)))
(def input (r/adapt-react-class (.-TextInput ReactNative)))

(def autocomplete-input (r/adapt-react-class (.-default react-native-autocomplete-input)))

(def logo-img (js/require "./images/logo.png"))

(defn alert [title]
      (.alert (.-Alert ReactNative) title))
