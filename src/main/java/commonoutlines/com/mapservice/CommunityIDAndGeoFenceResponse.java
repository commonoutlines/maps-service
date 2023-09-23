package commonoutlines.com.mapservice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityIDAndGeoFenceResponse {
        private int ID;
        private MapGeoFence GeoFence;

        public CommunityIDAndGeoFenceResponse(int ID, MapGeoFence GeoFence) {
            this.ID = ID;
            this.GeoFence = GeoFence;
        }



}
