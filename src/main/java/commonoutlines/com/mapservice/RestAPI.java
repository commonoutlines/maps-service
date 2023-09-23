package commonoutlines.com.mapservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Value;


@RestController
@RequestMapping("/api")
public class RestAPI {

    @Value("${custom.property1}")
    private String custom_propery;


    @Autowired
    private DatabaseManager dbman;


    @GetMapping("/hello")
    public String hello() {



        return "Hello, World!" + custom_propery;
    }

    @GetMapping("/hellojson")
    public SimpleJSONResponse getSimpleResponse() {
    SimpleJSONResponse response = new SimpleJSONResponse("Hello, Spring Boot!", "moredata");
        return response;

    }

    @GetMapping("/getCommunityIDBasedOnLocation")
    public CommunityIDAndGeoFenceResponse getCommunityIDBasedOnLocation( @RequestBody CommunityIDAndGeoFenceRequest request) {

        // Handle the received JSON data
        float lat = request.latitude;
        float lon = request.longitude;
        MapGeoFence bounds = MapServiceLogic.calculateBounds(lat, lon);
        String hash = MapServiceLogic.generateHash(bounds);
        //GetCommunityID from Database based on HASH
        int communityID = dbman.getCommunityIDWithHash(hash);
        return new CommunityIDAndGeoFenceResponse(communityID, bounds);

    }

    @GetMapping("/getCommunityIDBasedOnLocationAndInsertIntoDB")
    public CommunityIDAndGeoFenceResponse getCommunityIDBasedOnLocationAndInsertIntoDB( @RequestBody CommunityIDAndGeoFenceRequest request) {


        // Handle the received JSON data
        float lat = request.latitude;
        float lon = request.longitude;
        MapGeoFence bounds = MapServiceLogic.calculateBounds(lat, lon);
        String hash = MapServiceLogic.generateHash(bounds);
        dbman.insertCommunity( hash , bounds.latitudeMin, bounds.latitudeMax, bounds.longitudeMin, bounds.longitudeMax);
        int communityID = dbman.getCommunityIDWithHash(hash);
        return new CommunityIDAndGeoFenceResponse(communityID, bounds);

    }

    @GetMapping("/createTest")
    public String createTest() {
        return "";
    }


}