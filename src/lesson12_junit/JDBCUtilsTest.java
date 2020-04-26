package lesson12_junit;

import org.junit.*;

import lesson10_jdbc.JDBCUtils;
import lesson10_jdbc.ResultSetHandler;
import java.sql.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class JDBCUtilsTest {
	private Connection c;
	private PreparedStatement ps;
	private ResultSet rs;
	private ResultSetHandler<Object> rsh;

	@SuppressWarnings("unchecked")
	@Before
	public void before() {
		c = mock(Connection.class);
		ps = mock(PreparedStatement.class);
		rs = mock(ResultSet.class);
		rsh = mock(ResultSetHandler.class);
	}

	@Test
	public void testSelecWithoutParams() throws SQLException {
		Object expectedResult = new Object();
		when(c.prepareStatement("select (1+1)")).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(rsh.handle(rs)).thenReturn(expectedResult);
		Object actualResult = JDBCUtils.select(c, "select (1+1)", rsh);
		verify(c).prepareStatement("select (1+1)");
		verify(ps).executeQuery();
		verify(rsh).handle(rs);
		verify(ps, never()).setObject(anyInt(), any());
		verify(rs).close();
		verify(ps).close();
		assertSame(expectedResult, actualResult);
	}
}