;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; London Clojurains Website
;;
;; A ClojureScript single page app with reagent
;; Created with Clojure CLI tools and figwheel-main template
;; https://ldnclj.github.io
;;
;; Author(s): John Stevenson
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;



(ns ^:figwheel-hooks org.londonclojurians.landing-page
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent]
   [reagent.dom :as dom]))


;; simple debug statement for each build
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(println (js/Date.) "Reloading: src/org/londonclojurians/landing_page.cljs")


;; Application State
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; define your app data so that it doesn't get over-written on reload
(defonce app-state
  (reagent/atom {:text "London Clojurians"}))


;; Website structure
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defn main-page
  "The layout of components on the main page."
  []
  [:div
   [:h1 (:text @app-state)]])



;; System configuration code
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn get-app-element []
  (gdom/getElement "app"))


(defn mount [el]
  (dom/render [main-page] el))


(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
