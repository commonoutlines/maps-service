package commonoutlines.com.mapservice;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommunityEntityRowMapper implements RowMapper<CommunityEntity> {
    @Override
    public CommunityEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        CommunityEntity entity = new CommunityEntity();

        entity.setId(resultSet.getInt("id"));
        entity.setDescription(resultSet.getString("description"));
        entity.setLatitudemin(resultSet.getFloat("latitudemin"));
        entity.setLatitudemax(resultSet.getFloat("latitudemax"));
        entity.setLongitudemin(resultSet.getFloat("longitudemin"));
        entity.setLongitudemax(resultSet.getFloat("longitudemax"));
        return entity;
    }
}
