package commonoutlines.com.mapservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}