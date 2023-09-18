package commonoutlines.com.mapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
		String sql = "INSERT INTO students (name, email) VALUES ("
				+ "'Nam Ha Minh', 'nam@codejava.net')";

		int rows = jdbcTemplate.update(sql);
		if (rows > 0) {
			System.out.println("A new row has been inserted.");
		}
	}

}
