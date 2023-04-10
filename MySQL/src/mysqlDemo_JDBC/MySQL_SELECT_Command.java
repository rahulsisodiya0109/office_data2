package mysqlDemo_JDBC;

/*
 * this is for java database connectivity
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * 
 When INSERT, UPDATE & DELETE
1) Create a connection
2) Create statement/query
3) Execute statement/query
4) Store data into result set object
5) Close connection
*
*/
public class MySQL_SELECT_Command {

	public static void main(String[] args) throws Exception {

		// 1) Create a connection

		/*
		 * for mysql the connection string would be like this, for other databases it
		 * could be different
		 */

		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "systango@@");

		// 2) Create statement/query

		Statement stmt = connect.createStatement();
		String str = "SELECT * FROM employees";

		// 3) Execute statement/query & 4) Store data into result set object
		// Will be using executeQuery method to execute here

		ResultSet result = stmt.executeQuery(str);

		while (result.next()) {
			// here specify the column name in the table and store them in variable
			int id = result.getInt("employee_id");
			String firstName = result.getString("first_name");
			String lastName = result.getString("last_name");
			String jobID = result.getString("job_id");

			System.out.println(id + "  " + firstName + "  " + lastName+"      " +jobID);
		}

		// 5) Close connection
		connect.close();

		System.out.println("Query run successfully,..");

	}
}
