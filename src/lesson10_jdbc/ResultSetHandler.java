package lesson10_jdbc;

import java.sql.*;

public interface ResultSetHandler<T> {
	T handle(ResultSet rs) throws SQLException;
}