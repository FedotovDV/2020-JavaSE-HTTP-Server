package lesson12_junit;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
	@Test
	public void testSum() {
		int actual = 2 + 2;
		int expected = 4;
		Assert.assertEquals(expected, actual);
	}
}