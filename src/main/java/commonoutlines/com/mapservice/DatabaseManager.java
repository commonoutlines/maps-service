package commonoutlines.com.mapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service

public class DatabaseManager  {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseManager(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void createTable() {
        String sql = "CREATE TABLE newclassszzzlesgoooo (user_id serial PRIMARY KEY,username VARCHAR ( 50 ) UNIQUE NOT NULL)";

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted.");
        }


    }

    public void insertCommunity(String hash, String latmin, String latmax, String lonmin, String lonmax){


        String sql =  "INSERT INTO communities (geofencehash, latitudemin , latitudemax , longitudemin, longitudemax) VALUES ('"+ hash +"' , " + new BigDecimal(latmin) + ", "+ new BigDecimal(latmax) + ", " + new BigDecimal(lonmin) +", "+ new BigDecimal(lonmax) +");";
        int rows = jdbcTemplate.update(sql);
        if (rows < 0) {
            System.out.println("Error occured inserting row");
        }
    }

    public int getCommunityIDWithHash(String hash){


        int id = 0;
        String sqlquery = "SELECT * from communities where geofencehash ='" + hash +"'";
        List<CommunityEntity> entities = jdbcTemplate.query(sqlquery, new CommunityEntityRowMapper());
        for (CommunityEntity entity : entities) {
            //Only expect the one entity per hash
            id = entity.getId();
            return id;
        }

        return 0;
    }

}
