import java.sql.Connection;
import java.sql.DriverManager;


public class MainClass {
	public static void main(String[] args) {
		Connection connection;
		final String dbUrlString = "jdbc:sqlite:database.db";
		try {
			//Class.forName("org.sqlite.JDBC");
			DriverManager.getConnection(dbUrlString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
