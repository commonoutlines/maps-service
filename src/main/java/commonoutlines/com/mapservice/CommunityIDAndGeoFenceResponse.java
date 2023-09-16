package commonoutlines.com.mapservice;


import java.math.BigDecimal;

public class CommunityIDAndGeoFenceResponse {
        private int ID;
        private BigDecimal[] GeoFence;

        public CommunityIDAndGeoFenceResponse(int ID, BigDecimal[] GeoFence) {
            this.ID = ID;
            this.GeoFence = GeoFence;
        }

        public int getID() {
            return ID;
        }

        public void setID(String message) {
            this.ID = ID;
        }

        public BigDecimal[] getGeoFence() {
        return GeoFence;
        }

        public void setGeoFence(BigDecimal[] GeoFence) {
        this.GeoFence = GeoFence;
        }


}
