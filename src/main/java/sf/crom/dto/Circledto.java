package sf.crom.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.derby.jdbc.ClientDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sf.crom.beans.Circle;

@Component
public class Circledto {

	@Autowired
	private DataSource datasource;
	
	public Circle getCircle(int circleID) throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		//Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		//Connection con = DriverManager
			//	.getConnection("jdbc:derby://localhost:1527/db");
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
