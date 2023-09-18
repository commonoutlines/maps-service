package commonoutlines.com.mapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class MapServiceApplication implements CommandLineRunner{


	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(MapServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		String sql = "CREATE TABLE accounts (user_id serial PRIMARY KEY,username VARCHAR ( 50 ) UNIQUE NOT NULL)";

		int rows = jdbcTemplate.update(sql);
		if (rows > 0) {
			System.out.println("A new row has been inserted.");
		}
	}

}
