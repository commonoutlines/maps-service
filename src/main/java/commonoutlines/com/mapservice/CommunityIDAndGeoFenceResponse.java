package commonoutlines.com.mapservice;


import java.math.BigDecimal;

public class CommunityIDAndGeoFenceResponse {
        private String ID;
        private MapGeoFence GeoFence;

        public CommunityIDAndGeoFenceResponse(String ID, MapGeoFence GeoFence) {
            this.ID = ID;
            this.GeoFence = GeoFence;
        }

        public String getID() {
            return ID;
        }

        public void setID(String message) {
            this.ID = ID;
        }

        public MapGeoFence getGeoFence() {
        return GeoFence;
        }

        public void setGeoFence(MapGeoFence GeoFence) {
        this.GeoFence = GeoFence;
        }


}
