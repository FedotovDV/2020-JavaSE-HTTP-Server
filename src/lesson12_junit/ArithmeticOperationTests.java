package lesson12_junit;

import org.junit.Assert;
import org.junit.Test;

public class ArithmeticOperationTests {
	@Test
	public void testSum() {
		int actual = 2 + 2;
		Assert.assertEquals(4, actual);
	}

	@Test
	public void testDiff() {
		int actual = 2 - 2;
		Assert.assertEquals(0, actual);
	}

	@Test
	public void testMul() {
		int actual = 2 * 2;
		Assert.assertEquals(4, actual);
	}

	@Test
	public void testDiv() {
		int actual = 2 / 2;
		Assert.assertEquals(1, actual);
	}
}