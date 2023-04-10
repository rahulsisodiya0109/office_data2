package mysqlDemo_JDBC;

/*
 * this is for java database connectivity
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
 * 
 When INSERT, UPDATE & DELETE
1) Create a connection
2) Create statement/query
3) Execute statement/query
4) Close connection
*
*/
public class MySQL_DML_Command {

	public static void main(String[] args) throws Exception {

		// 1) Create a connection

		/*
		 * for mysql the connection string would be like this, for other databases it
		 * could be different
		 */

		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb1", "root", "systango@@");
		
		// 2) Create statement/query
		Statement stmt = connect.createStatement();
		//String str = "INSERT INTO STUDENT VALUE (100, 'mysql')";
		//String str = "UPDATE STUDENT SET NAME = 'mysql_update' where ID = 100";
		String str = "DELETE FROM STUDENT WHERE ID = 100";
		
		// 3) Execute statement/query
		stmt.execute(str);
		
		// 4) Close connection
		connect.close();
		
		System.out.println("Query run successfully,..");
		

	}
}
