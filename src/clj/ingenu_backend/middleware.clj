(ns ingenu-backend.middleware
  (:require
    [ingenu-backend.env :refer [defaults]]
    [ingenu-backend.config :refer [env]]
    [ring.middleware.flash :refer [wrap-flash]]
    [immutant.web.middleware :refer [wrap-session]]
    [ring.middleware.defaults :refer [site-defaults wrap-defaults]]))

(defn wrap-base [handler]
  (-> ((:middleware defaults) handler)
      wrap-flash
      (wrap-session {:cookie-attrs {:http-only true}})
      (wrap-defaults
        (-> site-defaults
            (assoc-in [:security :anti-forgery] false)
            (dissoc :session)))))
