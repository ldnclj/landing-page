;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; London Clojurians landing page - content
;;
;; Functions that represent content areas of the landing page
;;
;; Author(s): John Stevenson
;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(ns org.londonclojurians.content)


(defn navigation
  [content]
  [:nav {:class      "navbar is-fixed-top is-success"
         :role       "navigation"
         :aria-label "main navigation"}
   [:div {:class "container"}
    [:div {:class "navbar-brand"}
     [:a {:class "navbar-item"
          :href  "/"}
      [:img {:src (:logo-svg content)}]]
     [:span {:class       "navbar-burger burger"
             :data-target "navbarldnclj"}
      ;; Empty spans needed for navbar burger
      [:span] [:span] [:span]]]
    [:div {:id    "navbarldnclj"
           :class "navbar-menu"}
     [:div {:class "navbar-start"}

      [:a {:class "navbar-item"
           :href  "#events"} "Events"]

      [:a {:class "navbar-item"
           :href  "#videos"} "Videos"]

      [:a {:class "navbar-item"
           :href  "#practice"} "Practice"]

      [:a {:class "navbar-item"
           :href  "#connect"} "Connect"]

      [:a {:class "navbar-item"
           :href  "#resources"} "Resources"]

      [:a {:class "navbar-item"
           :href  "#code-of-conduct"} "Code of conduct"]

      [:span {:class "navbar-item"}
       [:a {:class  "button is-inverted"
            :target "_blank"
            :href   (:issues content)}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]
        [:span "Issues/PRs"]]]]]]])



(defn title-banner
  "Top banner and navigation for the website"
  [content]
  [:section {:class "section"}
   [:div {:class "container"}
    [:div {:class "columns is-vcentered"}

     [:div {:class "column is-2 is-offset-1"}
      [:img {:src   (:logo-svg content)
             :width "160px"}]]

     [:div {:class "column"}
      [:h1 {:class "title is-1"}
       (:title content)]
      [:h3 {:class "subtitle"}
       "Open and welcoming community, supporting your journey into coding with Clojure"]
      [:div {:class "content"}
       "Encourage everyone to code with Clojure and learn functional programming. Supporting those new to coding via our "
       [:a {:href "https://clojurebridgelondon.github.io/"
            :target "_blank"}
        "ClojureBridge London events"]
       ". Supporting the developer community with free online talks and dojo's to practice Clojure coding"]
      [:div {:class "content"}
       "All members of the community follow the London Clojurians code of conduct when interacting with members and representing the community to the wider world"]]]]])

(defn sponsorship
  [sponsor]
  [:div {:class "container"}
   [:div {:class "box"}
    [:div {:class "columns is-vcentered"}

     [:div {:class "column"}
      [:a {:href   (:url sponsor)
           :target "_blank"}

       [:figure {:class "image"}
        [:img {:src (:logo sponsor)}]]]]

     [:div {:class "column"}
      [:h4 {:class "title has-text-centered is-size-4"}
       "Support our community via our "
       [:a {:href (:url sponsor)
            :target "_blank"}
        "Open Collective sponsorship of London Clojurians"]]
      [:div {:class "content has-text-centered"}
       "Support our monthly meetups, community conference and "
       [:a {:href "https://clojurebridgelondon.github.io/"
            :target "_blank"}
        "ClojureBridge London events"]]]]]])


(defn community-events
  [events]
  [:div {:class "container"}
   [:div {:class "box"}
    [:div {:class "columns is-vcentered"}

     [:div {:class "column"}
      [:a {:href   (-> events :next :url)
           :target "_blank"}
       [:figure {:class "image"}
        [:img {:src (-> events :next :logo)}]]]]

     [:div {:class "column"}
      [:h3 {:class "title is-3 has-text-centered"}
       "Monthly online talks from the community"]
      [:p {:class "content has-text-weight-bold"}
       "Date / time of next event: "
       [:a {:href (-> events :next :time-is)
            :target "_blank"}
        (-> events :next :date)]]
      [:p {:class "content"}
       (-> events :next :summary)]
      [:div {:class "content has-text-weight-bold"}
       [:a {:href   (-> events :next :url)
            :target "_blank"}
        "Sign up via meetup.com/london-clojurians"]]
      [:p
       "(free meetup.com account required)"]]]]])


(defn youtube-playlists-list
  [youtube-links]
  [:div {:class "content"}
   [:h2 {:class "title has-text-centered"}
    "Practicalli Video Playlists"]
   [:ul {:style {:list-style-type "none"}}
    [:li [:a {:href   (get-in youtube-links [:playlists :practicalli-clojure-study-group])
              :target "_blank"}
          [:span {:class "icon"}
           [:i {:class "fab fa-youtube"}]]
          "Clojure study group"]]
    [:li [:a {:href   (get-in youtube-links [:playlists :practicalli-clojure-cli-tools])
              :target "_blank"}
          [:span {:class "icon"}
           [:i {:class "fab fa-youtube"}]]
          "Clojure CLI tools and deps.edn"]]
    [:li [:a {:href   (get-in youtube-links [:playlists :practicalli-spacemacs])
              :target "_blank"}
          [:span {:class "icon"}
           [:i {:class "fab fa-youtube"}]]
          "Spacemacs - Emacs and Vim tools for (Clojure) development"]]
    [:li [:a {:href   (get-in youtube-links [:playlists :practicalli-4clojure-guides])
              :target "_blank"}
          [:span {:class "icon"}
           [:i {:class "fab fa-youtube"}]]
          "4Clojure Guides"]]
    [:li [:a {:href   (get-in youtube-links [:playlists :practicalli-clojure-spec])
              :target "_blank"}
          [:span {:class "icon"}
           [:i {:class "fab fa-youtube"}]]
          "Clojure Spec & Generative Testing"]]
    [:li [:a {:href   (get-in youtube-links [:playlists :practicalli-clojure-webapps])
              :target "_blank"}
          [:span {:class "icon"}
           [:i {:class "fab fa-youtube"}]]
          "Clojure Server-side WebApps & APIs"]]
    [:li [:a {:href   (get-in youtube-links [:playlists :practicalli-clojure-data-science])
              :target "_blank"}
          [:span {:class "icon"}
           [:i {:class "fab fa-youtube"}]]
          "Clojure Data Science and Visualization"]]
    ]
   ])


(defn youtube-embed-video
  "Generate an iframe to display a YouTube video,
  using a default video id as a backup value

   Argument: YouTube video id as a string
   Returns:
    Column containing an iframe for a YouTube video as hiccup"
  [video-id]
  [:div {:class "column is-3"}
   [:figure {:class "image"}
    [:iframe {:class             "embed-responsive-item"
              :allow-full-screen "allowfullscreen"
              :frame-border      0
              :auto-play         1
              :src               (str "https://www.youtube.com/embed/"
                                      (or  video-id "NDrpclY54E0"))}]]])


(defn youtube-gallery
  "Display 4 videos after shuffling the available videos"
  [videos]
  [:div {:class "container"}
   [:div {:class "box"}
    [:h2 {:class "title has-text-centered"}
     [:a {:href "https://www.youtube.com/c/LondonClojurians/videos"
          :target "_blank"}
      "London Clojurians - recorded events"]]
    [:div {:class "columns"}
     (for [video (take 4 (shuffle videos))]
       (youtube-embed-video (:id video)))]]])


(defn practice-clojure
  "Events for practicing Clojure"
  []
  [:div {:class "container"}
   [:div {:class "box"}
    [:h2 {:class "title has-text-centered"}
     "Events to practice Clojure"]

    [:div {:class "columns"}

     [:div {:class "column is-6"}
      [:h2 {:class "title has-text-centered"}
       "Monthly Coding Dojos"]
      [:div {:class "content"}
       [:p "In-person groups of 2-4 people tackle self-selected small coding challenges and share lessons learned with everyone at the end"]

       [:ul
        [:li "2nd Monday at "
         [:a {:href "https://www.uswitch.com/vacancies/"
              :target "_blank"}
          "uSwitch"] " - near Tower Bridge"]
        [:li "Last Tuesday "
         [:a {:href "https://info.thoughtworks.com/London-office.html"
              :target "_blank"}
          "ThoughtWorks"] " - near Piccadilly Circus"]]
       [:div {:class "content is-italic"}
        "NOTE: Dojo events not running during the pandemic"]]]

     [:div {:class "column is-6"}
      [:h2 {:class "title has-text-centered"}
       "Weekly live broadcasts"]
      [:div {:class "content"}
       [:p "Walk through solutions to code challenges, build websites and learn Clojure CLI tools with "
        [:a {:href "https://practicalli.github.io/"
             :target "_blank"} "Practicalli"]]
       [:h6 {:class "title is-size-6"} "Playlists of recorded broadcasts"]
       [:ul
        [:li [:a {:href "https://www.youtube.com/playlist?list=PLpr9V-R8ZxiDjyU7cQYWOEFBDR1t7t0wv"
                      :target "_blank"} "Weekly Clojure study group"]]
        [:li [:a {:href "https://www.youtube.com/playlist?list=PLpr9V-R8ZxiDB_KGrbliCsCUrmcBvdW16"
              :target "_blank"} "4Clojure.com code solutions"]]]]]]]])


(defn connect-with-the-community
  "Channels to connect with the Clojure community"
  [contact-channels]
  [:div {:class "container"}
   [:div {:class "box"}
    [:h2 {:class "title has-text-centered"}
     "Connect with the Clojure Community"]
    [:h4 {:class "title is-4 has-text-centered"}
     [:a {:href "https://practicalli.github.io/blog/posts/cloure-community-getting-help/"
          :target "_blank"}
      "Guide to getting help from the community"]]

    [:div {:class "columns"}

     #_[:div {:class "column"}
        [:a {:href   (get-in contact-channels [:ask-clojure :url])
             :target "_blank"}
         [:figure {:class "image"}
          [:img {:src (get-in contact-channels [:ask-clojure :logo])}]]]]

     #_[:div {:class "column"}
        [:a {:href   (get-in contact-channels [:clojureverse :url])
             :target "_blank"}
         [:figure {:class "image"}
          [:img {:src (get-in contact-channels [:clojureverse :logo])}]]]]

     [:div {:class "column"}
      [:a {:href   (get-in contact-channels [:zulip :url])
           :target "_blank"}
       [:figure {:class "image"}
        [:img {:src (get-in contact-channels [:zulip :logo])}]]]
      [:p {:class "has-text-centered"}
       "Includes Slack discussions archive and realtime discussions of the Clojure data science community"]]

     [:div {:class "column"}
      [:a {:href   (get-in contact-channels [:slack  :url])
           :target "_blank"}
       [:figure {:class "image"}
        [:img {:src (get-in contact-channels [:slack  :logo])}]]]

      [:a {:href   "http://clojurians.net"
           :target "_blank"}
       [:p {:class "has-text-centered"}
        "Sign up for a free account to the Clojurians Slack community"]]]]]]) ;; End of contact


(defn resources
  "Useful resources during the workshop.

  Where to go next after the workshop."
  []
  [:div {:class "container"}
   [:div {:class "box"}
    [:div {:class "columns"}

     [:div {:class "column"}
      [:h4 {:class "title is-4"} "Resources"]
      [:table {:class "table"}
       [:tbody
        [:tr
         [:th
          [:a {:href "https://clojuredocs.org/" :target "_blank"} "Clojure docs"]]
         [:td "docs for functions"]]
        [:tr
         [:th
          [:a {:href "https://clojure.org/" :target "_blank"} "Clojure.org"]]
         [:td "language and concepts"]]
        [:tr
         [:th
          [:a {:href "https://cljdoc.org/" :target "_blank"} "CljDocs"]]
         [:td "search library docs"]]
        [:tr
         [:th
          [:a {:href "https://clojuredesign.club/" :target "_blank"} "Clojure Design Club"]]
         [:td "Podcast discussing Clojure design"]]]]]


     [:div {:class "column"}
      [:h4 {:class "title is-4"} "Practicing"]
      [:table {:class "table"}
       [:tbody
        [:tr
         [:th
          [:a {:href "http://www.4clojure.com/" :target "_blank"} "4Clojure"]]
         [:td "learn Clojure functions"]]
        [:tr
         [:th
          [:a {:href "https://exercism.io/tracks/clojure" :target "_blank"} "Exercism"]]
         [:td "code practice & mentorship"]]
        [:tr
         [:th
          [:a {:href "https://www.codingame.com/" :target "_blank"} "CodinGame"]]
         [:td "practice & learn the fun way"]]]]]

     [:div {:class "column"}
      [:h4 {:class "title is-4"} "Online books"]
      [:table {:class "table"}
       [:tbody
        [:tr
         [:th
          [:a {:href "https://github.com/clojure-cookbook/clojure-cookbook"
               :target "_blank"} "Clojure Cookbook"]]]
        [:tr
         [:th
          [:a {:href "http://practicalli.github.io/" :target "_blank"} "Practicalli Clojure"]]]
        [:tr
         [:th
          [:a {:href "http://funcool.github.io/clojurescript-unraveled/" :target "_blank"} "ClojureScript Unraveled"]]]
        [:tr
         [:th
          [:a {:href "https://www.braveclojure.com/clojure-for-the-brave-and-true/" :target "_blank"} "Brave Clojure"]]]]]]

     [:div {:class "column"}
      [:h4 {:class "title is-4"} "Videos"]
      [:table {:class "table"}
       [:tbody
        [:tr
         [:th
          [:a {:href "https://www.youtube.com/user/ClojureTV" :target "_blank"} "Clojure TV"]]
         [:td "conference talks"]]
        [:tr
         [:th
          [:a {:href "https://www.youtube.com/watch?v=9A9qsaZZefw&list=PLAC43CFB134E85266" :target "_blank"} "Clojure Language"]]
         [:td "describing language concepts"]]
        [:tr
         [:th
          [:a {:href "https://www.youtube.com/playlist?list=PLpr9V-R8ZxiDjyU7cQYWOEFBDR1t7t0wv" :target "_blank"} "Practicalli study group"]]
         [:td "weekly practical lessons"]]
        [:tr
         [:th
          [:a {:href "http://www.parens-of-the-dead.com/" :target "_blank"} "Parens of the dead"]]
         [:td "a card game in Clojure"]]]]]]]])


(defn code-of-conduct
  "Code of Conduct"
  []
  [:div {:class "container"}
   [:div {:class "box"}
    [:div {:class "content"}
     [:h2 {:class "title has-text-centered"}
      "London Clojurians Code Of Conduct"]
     [:p "All members of the London Clojurians community are required to act and interact with other members with respect to the code of conduct, providing a harassment-free experience and equality for all. Negative or disparaging words or actions should not be directed at people due to their age, body size, visible or invisible disability, ethnicity, sex characteristics, gender identity and expression, level of experience, education, socio-economic status, nationality, personal appearance, race, caste, color, religion, or sexual identity and orientation."]

     [:p "If you experience or witness any harassment or behaviour that makes you feel uncomfortable in any way, please let us know in person at events or via the London Clojurian Organisers.  The quicker we know about an issue, the sooner we can consider how to resolve it and prevent further issues"]

     [:h3 {:class "title"}
      "Harassment (Quick Version)"]
     [:p "Clojurians is dedicated to providing a harassment-free experience for everyone, regardless of gender, sexual orientation, disability, physical appearance, body size, race, or religion. We do not tolerate harassment of Slack participants in any form. Sexual language and imagery is not appropriate for any chat topic. Participants violating these rules will be expelled from the group at the sole discretion of the group administrators."]

     [:h3 {:class "title"}
      "Harassment (Less Quick Version)"]
     [:p "Harassment includes offensive verbal comments related to gender, sexual orientation, disability, physical appearance, body size, race, religion, sexual images, deliberate intimidation, stalking, sustained disruption of discussions or other events, and unwelcome sexual attention."]
     [:p "Participants asked to stop any harassing behavior are expected to comply immediately."]
     [:p "If you are being harassed, notice that someone else is being harassed, or have any other concerns, please notify a Slack administrator immediately."]
     [:p "We expect participants to follow these rules in all discussions in our Slack channels. We think people should follow these rules outside of Slack too!"]

     [:h3 {:class "title"}
      "Our Standards"]

     [:p "Examples of behavior that contributes to a positive environment for our community include:"]
     [:ul
      [:li "Demonstrating empathy and kindness toward other people"]
      [:li "Being respectful of differing opinions, viewpoints, and experiences"]
      [:li "Giving and gracefully accepting constructive feedback"]
      [:li "Accepting responsibility and apologizing to those affected by our mistakes, and learning from the experience"]
      [:li "Focusing on what is best not just for us as individuals, but for the overall community"]]

     [:p "Examples of unacceptable behavior include:"]
     [:ul
      [:li "The use of sexualized language or imagery, and sexual attention or advances of any kind"]
      [:li "Trolling, insulting or derogatory comments, and personal or political attacks"]
      [:li "Public or private harassment"]
      [:li "Publishing others' private information, such as a physical or email address, without their explicit permission"]
      [:li "Other conduct which could reasonably be considered inappropriate in a professional setting"]]

     [:h3 {:class "title"}
      "Enforcement Responsibilities"]

     [:p "Community leaders are responsible for clarifying and enforcing our standards of acceptable behavior and will take appropriate and fair corrective action in response to any behavior that they deem inappropriate, threatening, offensive, or harmful."]
     [:p "Community leaders have the right and responsibility to remove any behavior that is not aligned to this Code of Conduct and will communicate reasons for moderation decisions when appropriate."]

     [:h3 {:class "title"}
      "Scope"]

     [:p "This Code of Conduct applies within all community spaces, and also applies when an individual is officially representing the community in public spaces. Examples of representing our community include using an official e-mail address, posting via an official social media account, or acting as an appointed representative at an online or offline event."]

     [:h3 {:class "title"}
      "Enforcement"]
     [:p "Instances of abusive, harassing, or otherwise unacceptable behavior may be reported to the community leaders responsible for enforcement All complaints will be reviewed and investigated promptly and fairly."]
     [:p "All community leaders are obligated to respect the privacy and security of the reporter of any incident."]

     ]]]) ;; End of code-of-content



;; helper functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defn level-separator
  "A separator to provide a gap between components.
  The separator takes an id so that the section
  does not get hidden by the menu when linking"
  [identifier]
  [:div {:class "level"
         :id    identifier}
   [:h5 {:class "is-size-5 is-invisible"}
    identifier]])
