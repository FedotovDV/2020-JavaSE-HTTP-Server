package lesson10;

import java.sql.*;

public class GetConnectionTest {
	public static void main(String[] args) throws SQLException {
		try(Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myDBPostgres",
		"user", "root")){
		System.out.println(c.isValid(0));
		}
	}
}