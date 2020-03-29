package lesson10;

import java.sql.*;
import java.util.*;

public class BatchOperations {
	public static void main(String[] args) throws SQLException {
		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myDBPostgres", "user",
				"root")) {
			try (PreparedStatement ps = c.prepareStatement("insert into student values(?,?,?,?)")) {
				for (int i = 0; i < 20; i++) {
					ps.setLong(1, 100 + i);
					ps.setString(2, "Jack" + i);
					ps.setString(3, "Sparrow" + i);
					ps.setInt(4, new Random().nextInt(10) + 18);
					ps.addBatch();
				}
				int[] inserted = ps.executeBatch();
				System.out.println("Inserted " + Arrays.toString(inserted) + " rows");
			}
		}
	}
}