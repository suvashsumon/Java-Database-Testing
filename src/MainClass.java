import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class MainClass {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		final String dbUrlString = "jdbc:sqlite:database.db";
		String searchUser = "SELECT * FROM Contacts WHERE \"Student ID\"=\"1910476124\" AND \"Phone\"=\"01717601509\"";
		String getData = "SELECT * FROM Contacts";
		try {
			//Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(dbUrlString);
			
			statement = connection.createStatement();
			resultSet = statement.executeQuery(searchUser);
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfCollumn = metaData.getColumnCount();
			while(resultSet.next()) {
				for(int i=1; i<=numberOfCollumn; i++) {
					System.out.print(resultSet.getObject(i)+" ");
				}
				System.out.println();
			}
			resultSet.close();
			statement.close();
			connection.close();
			JOptionPane.showMessageDialog(null, "Done!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
