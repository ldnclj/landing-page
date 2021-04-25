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
   [reagent.dom :as dom]

   [org.londonclojurians.content :as content]
   [org.londonclojurians.youtube :as youtube]))


;; simple debug statement for each build
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(println (js/Date.) "Reloading: src/org/londonclojurians/landing_page.cljs")


;; Application State
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; define your app data so that it doesn't get over-written on reload

(defonce app-state
  (reagent/atom {:website {:title "London Clojurians"
                           :url "https://lndclj.github.io/"
                           :issues "https://github.com/ldnclj/landing-page/issues"
                           :logo-svg "https://raw.githubusercontent.com/practicalli-john/london-clojurians-logo/master/london-clojurians-logo.svg"
                           :logo-png "https://raw.githubusercontent.com/practicalli-john/london-clojurians-logo/master/london-clojurians-logo.png"}
                 :events
                 {:next {:url "https://www.meetup.com/London-Clojurians/events/276255080/"
                         :logo "https://secure.meetupstatic.com/photos/event/9/b/5/8/600_494679768.jpeg"
                         :date "27th April 2021"
                         :time-is "https://time.is/1830_27_April_2021_in_London/"
                         :summary "30 years of Internet through the lens of HTTP protocol versions diff. HTTP/3 brings the most significant changes we've seen so far, so let's review them alongside with reasoning and implications analysis."}
                  :meetup {:url "https://meetup.com/london-clojurians/"}}
                 :contact-channels
                 {:ask-clojure
                  {:url "https://clojurians.slack.com/messages/beginners"
                   :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/practicalli-slack-channel.png"}
                  :clojureverse
                  {:url "https://clojurians.slack.com/messages/beginners"
                   :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/practicalli-slack-channel.png"}
                  :slack
                  {:url "https://clojurians.slack.com/messages/beginners"
                   :logo "https://raw.githubusercontent.com/practicalli-john/london-clojurians-logo/master/london-clojurians-slack-badge.png"}
                  :zulip
                  {:url "https://clojurians.zulipchat.com/"
                   :logo "https://raw.githubusercontent.com/practicalli-john/london-clojurians-logo/master/london-clojurians-zulip-badge.png"}}
                 :sponsorship
                 {:open-collective {:url "https://opencollective.com/london-clojurians"
                                    :logo "https://raw.githubusercontent.com/practicalli-john/london-clojurians-logo/master/london-clojurians-open-collective-logo.png"}}
                 :external-content
                 {:youtube youtube/community-video-ids}}))


;; Website structure
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn main-page
  "The layout of components on the main page."
  []
  [:div
   [content/navigation (:website @app-state)]

   [content/title-banner (:website @app-state)]

   [content/sponsorship (-> @app-state :sponsorship :open-collective)]

   [content/level-separator "events"]
   [content/community-events (:events @app-state)]

   ;; YouTube videos random selection
   [content/level-separator "videos"]
   [content/youtube-gallery (-> @app-state :external-content :youtube)] ;; [{:id "" :title ""} ,,,]

   [content/level-separator "practice"]
   [content/practice-clojure]

   [content/level-separator "connect"]
   [content/connect-with-the-community (:contact-channels @app-state)]

   [content/level-separator "resources"]
   [content/resources]

   [content/level-separator "code-of-conduct"]
   [content/code-of-conduct]])


;; System configuration code
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [element]
  (dom/render [main-page] element))

(defn mount-app-element []
  (when-let [element (get-app-element)]
    (mount element)))

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
