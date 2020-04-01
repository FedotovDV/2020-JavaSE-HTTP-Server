package lesson10_jdbc;

import java.sql.*;

import javax.sql.DataSource;

import org.postgresql.ds.PGPoolingDataSource;

public class GetConnectionTest {
	public static void main(String[] args) throws SQLException {
//		try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myDBPostgres", "user",
//				"root")) {
//			System.out.println(c.isValid(0));
//		}
		DataSource ds = createPostgresqlDataSource();
		try {
			try (Connection c = ds.getConnection()) {
				System.out.println(c.isValid(0));
			}
		} finally {
			((PGPoolingDataSource) ds).close();
		}
	}

	private static DataSource createPostgresqlDataSource() {
		PGPoolingDataSource ds = new PGPoolingDataSource();
		ds.setDataSourceName("A Data Source");
		ds.setServerName("localhost");
		ds.setDatabaseName("myDBPostgres");
		ds.setUser("user");
		ds.setPassword("root");
		ds.setInitialConnections(1);
		ds.setMaxConnections(3);
		return ds;
	}
}