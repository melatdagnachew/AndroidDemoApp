package com.gebeya.myapplication;

public class Route {
        String routeName;
        String routeTime;
        int totalStops;
        int deliveredStops;
        int missedStops;
        int failedStops;


        public Route(String routeName, String routeTime, int totalStops, int deliveredStops, int missedStops, int failedStops) {
                this.routeName = routeName;
                this.routeTime = routeTime;
                this.totalStops = totalStops;
                this.deliveredStops = deliveredStops;
                this.missedStops = missedStops;
                this.failedStops = failedStops;
        }

      public Route(String routeName, String routeTime, int totalStops) {
                this.routeName = routeName;
                this.routeTime = routeTime;
                this.totalStops = totalStops;
        }



        public String getRouteName() {
                return routeName;
        }

        public void setRouteName(String routeName) {
                this.routeName = routeName;
        }

        public String getRouteTime() {
                return routeTime;
        }

        public void setRouteTime(String routeTime) {
                this.routeTime = routeTime;
        }

        public int getTotalStops() {
                return totalStops;
        }

        public void setTotalStops(int totalStops) {
                this.totalStops = totalStops;
        }

        public int getDeliveredStops() {
                return deliveredStops;
        }

        public void setDeliveredStops(int deliveredStops) {
                this.deliveredStops = deliveredStops;
        }

        public int getMissedStops() {
                return missedStops;
        }

        public void setMissedStops(int missedStops) {
                this.missedStops = missedStops;
        }

        public int getFailedStops() {
                return failedStops;
        }

        public void setFailedStops(int failedStops) {
                this.failedStops = failedStops;
        }




}

