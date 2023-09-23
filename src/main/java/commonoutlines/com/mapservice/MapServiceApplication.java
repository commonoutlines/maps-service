package commonoutlines.com.mapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class MapServiceApplication{

	public static void main(String[] args) {
		SpringApplication.run(MapServiceApplication.class, args);
	}


}
