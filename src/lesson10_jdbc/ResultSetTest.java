package lesson10_jdbc;

import java.sql.*;

public class ResultSetTest {
	public static void main(String[] args) throws SQLException {
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myDBPostgres", "user",
				"root")) {
			try (Statement st = c.createStatement()) {
				try (ResultSet rs = st.executeQuery("select * from student")) {
					while (rs.next()) {
						System.out.println(
								rs.getLong(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
					}
				}
				System.out.println("-------------------------------------------------");
				try (ResultSet rs = st.executeQuery("select * from student")) {
					while (rs.next()) {
						System.out.println(rs.getLong("id") + ", " + rs.getString("first_name") + ", "
								+ rs.getString("last_name") + ", " + rs.getInt("age"));
					}
				}
			}
		}
	}
}