package genericUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseUtility {
	
	public String fetchDataFromDataBase(Connection connection, String SQLQuerry, int cellNo) throws SQLException {
		ResultSet result = connection.createStatement().executeQuery(SQLQuerry);

		while (result.next()) {
			return result.getString(cellNo);

		}
		
		return "";
	}
	
	public void updateDataToDataBase(Connection connection, String SQLQuerry) throws SQLException {
		int result = connection.createStatement().executeUpdate(SQLQuerry);
		
		if(result == 1) {
			System.out.println("Data base is updates");
		}
		
		else
			System.out.println("Data base is not updates");

	
	}

}
