package sf.crom.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.derby.jdbc.ClientDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import sf.crom.beans.Circle;

@Component
public class Circledto {

	private DataSource datasource;

	public DataSource getDatasource() {
		return datasource;
	}

	@Autowired
	public void setDatasource(DataSource datasource) {
		jdbctemplate = new JdbcTemplate(datasource);
	}

	private JdbcTemplate jdbctemplate;

	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return jdbctemplate.queryForInt(sql);
	}
	
	public String getCircleName(int circleId){
		String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";
		return (String)jdbctemplate.queryForObject(sql, new Object[]{circleId}, String.class);
		
	}

	public Circle getCircle(int circleID) throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		// Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		// Connection con = DriverManager
		// .getConnection("jdbc:derby://localhost:1527/db");
		Connection con = datasource.getConnection();
		PreparedStatement statement = con
				.prepareStatement("select * from circle where id = ?");
		statement.setInt(1, circleID);
		ResultSet rs = statement.executeQuery();
		Circle circle = null;
		if (rs.next()) {
			circle = new Circle(circleID, rs.getString("name"));
		}
		statement.close();
		con.close();
		return circle;
	}

}
