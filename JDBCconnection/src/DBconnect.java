import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnect {

	public static final String showPersons = "SELECT * FROM persons";

	public static final String showEmployees = "SELECT * FROM employees";

	private Connection con;
	private Statement state;
	private ResultSet rs;

	public DBconnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/study", "root", "antoan69");

			state = con.createStatement();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void viewPerson() {

		try {
			rs = state.executeQuery(showPersons);

			while (rs.next()) {
				String id = rs.getString("PersonID");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String address = rs.getString("Address");
				String city = rs.getString("City");

				System.out.printf("%s. %s \t %s   \t %s \t %s \n", id,
						firstName, lastName, address, city);

			}
		} catch (SQLException e) {
			System.out.println("Unable to execute query!");
			e.printStackTrace();
		}

	}

	public void viewEmployees() {

		try {
			rs = state.executeQuery(showEmployees);

			while (rs.next()) {

				String id = rs.getString("ID");
				String lastName = rs.getString("LastName");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				String postalCode = rs.getString("PostalCode");

				System.out.printf("%s. %-13s \t %-15s \t %-10s \t %s \n", id,
						lastName, address, city, postalCode);

			}
		} catch (SQLException e) {
			System.out.println("Unable to exequte query!");
			e.printStackTrace();
		}
	}

}
