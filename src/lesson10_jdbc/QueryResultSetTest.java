package lesson10_jdbc;

import java.sql.*;

public class QueryResultSetTest {
	public static void main(String[] args) throws SQLException {
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myDBPostgres", "user",
				"root")) {
			try (Statement st = c.createStatement()) {
				try (ResultSet rs = st.executeQuery("select * from student")) {
					ResultSetMetaData meta = rs.getMetaData();
					for (int i = 1; i <= meta.getColumnCount(); i++) {
						display(meta.getColumnLabel(i));
						if (i != meta.getColumnCount()) {
							System.out.print("| ");
						}
					}
					System.out.println("\n---------------------------------------");
					while (rs.next()) {
						for (int i = 1; i <= meta.getColumnCount(); i++) {
							display(String.valueOf(rs.getObject(i)));
							if (i != meta.getColumnCount()) {
								System.out.print("| ");
							}
						}
						System.out.println("\n---------------------------------------");
					}
				}
			}
		}
	}

	private static void display(String value) {
		System.out.print(value);
		for (int i = 0; i < 10 - value.length(); i++) {
			System.out.print(" ");
		}
	}
}