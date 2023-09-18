package commonoutlines.com.mapservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/api")
public class RestAPI {


    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
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

        BigDecimal[] bounds = calculateBounds(lat, lon);


            float[] geoFence = { 1.23f, 4.56f, 7.89f };
            return new CommunityIDAndGeoFenceResponse(1, bounds);


        }

        @GetMapping("/createTest")
        public String createTest() {
            return "";

        }

    public static BigDecimal[] calculateBounds(float longitude, float latitude) {
        BigDecimal lowerLongitude = BigDecimal.valueOf(longitude).setScale(3, RoundingMode.HALF_UP);
        lowerLongitude = lowerLongitude.subtract(lowerLongitude.remainder(BigDecimal.valueOf(0.005)));

        BigDecimal upperLongitude;

        if (longitude >= 0) {
            upperLongitude = lowerLongitude.add(BigDecimal.valueOf(0.01));
        } else {
            upperLongitude = lowerLongitude.subtract(BigDecimal.valueOf(0.01));
        }
        BigDecimal lowerLatitude = BigDecimal.valueOf(latitude).setScale(3, RoundingMode.HALF_UP);
        lowerLatitude = lowerLatitude.subtract(lowerLatitude.remainder(BigDecimal.valueOf(0.005)));
        
        BigDecimal upperLatitude;
        if (latitude >= 0) {
            upperLatitude = lowerLatitude.add(BigDecimal.valueOf(0.01));
        } else {
            upperLatitude = lowerLatitude.subtract(BigDecimal.valueOf(0.01));
        }
        return new BigDecimal[]{lowerLongitude, upperLongitude, lowerLatitude, upperLatitude};
    }

}