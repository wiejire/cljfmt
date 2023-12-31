(ns cljfmt.test-util.common
  (:require [cljfmt.core :refer [reformat-string]]
            [clojure.string :as str]))

(defn assert-reformats-to
  ([msg in-lines expected-lines]
   (assert-reformats-to msg in-lines expected-lines {}))
  ([msg in-lines expected-lines options]
   (let [input        (str/join "\n" in-lines)
         actual       (reformat-string input options)
         actual-lines (str/split actual #"\n" -1)]
     {:type (if (= expected-lines actual-lines) :pass :fail)
      :message  msg
      :expected expected-lines
      :actual   actual-lines})))
