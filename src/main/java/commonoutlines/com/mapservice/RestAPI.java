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

        return new CommunityIDAndGeoFenceResponse(hash, bounds);

    }

    @GetMapping("/getCommunityIDBasedOnLocationAndInsertIntoDB")
    public CommunityIDAndGeoFenceResponse getCommunityIDBasedOnLocationAndInsertIntoDB( @RequestBody CommunityIDAndGeoFenceRequest request) {

        CommunityIDAndGeoFenceResponse response =  getCommunityIDBasedOnLocation(request);
        dbman.insertCommunity(response.getID() , response.getGeoFence().latitudeMin, response.getGeoFence().latitudeMax, response.getGeoFence().longitudeMin, response.getGeoFence().longitudeMax);
        return response;
    }

    @GetMapping("/createTest")
    public String createTest() {
        return "";
    }


}