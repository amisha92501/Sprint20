package dataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class FetchData {

	public static void main(String[] args) throws SQLException {

		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vvtiger", "root", "root");

		ResultSet result = connection.createStatement().executeQuery("select * from lead;");

		while (result.next()) {
			System.out.println("First Name : " + result.getString(1));
			System.out.println("Last Name : " + result.getString(2));
			System.out.println("Company Name : " + result.getString(3));

		}

		connection.close();
	}

}
