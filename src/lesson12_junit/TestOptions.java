package lesson12_junit;

import org.junit.*;

public class TestOptions {
	@Test
	public void test1() {
		Assert.assertEquals(4, 2 + 2);
	}

	@Test
	@Ignore // может быть установлена на класс
	public void test2() {
		Assert.assertEquals(5, 2 + 2);
	}

	@Test(timeout = 1000)
	public void testTimeout() {
		while (true) {
			Assert.assertEquals(4, 2 + 2);
		}
	}

	@Test(expected = ArithmeticException.class)
	public void testExpectedException() {
		Assert.assertEquals(5, 2 / 0);
	}
}