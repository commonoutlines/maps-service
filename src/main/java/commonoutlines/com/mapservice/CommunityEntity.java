package commonoutlines.com.mapservice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommunityEntity {
        private int id;
        private String description;
        private String name;
        private String geofencehash;
        private float latitudemin;
        private float latitudemax;
        private float longitudemin;
        private float longitudemax;


    }
