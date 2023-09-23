package commonoutlines.com.mapservice;

public class MapGeoFence {

    public String longitudeMin;
    public String longitudeMax;
    public String latitudeMin;
    public String latitudeMax;

    public MapGeoFence(String longitudeMin, String longitudeMax, String latitudeMin, String latitudeMax) {
        this.longitudeMin = longitudeMin;
        this.longitudeMax = longitudeMax;
        this.latitudeMin = latitudeMin;
        this.latitudeMax = latitudeMax;
    }

}
