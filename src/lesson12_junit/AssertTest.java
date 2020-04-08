package lesson12_junit;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;

import  static org.junit.Assert.*;



public class AssertTest {
	@Test
	public void testAssertOptions() {
		assertArrayEquals(new int[] { 1 }, new int[] { 1 });
		Assert.assertEquals(5, 5);
		Assert.assertNotEquals(5, 4);
		Assert.assertFalse(3 > 4);
		Assert.assertTrue(2 > 1);
		Assert.assertSame(Integer.valueOf(2), Integer.valueOf(2));
		Assert.assertNotSame(Integer.valueOf(2), new Integer(2));
		Assert.assertNull(null);
		Assert.assertNotNull("String");
		// http://hamcrest.org/JavaHamcrest/
//		Assert.assertThat(Integer.valueOf(2), new IsInstanceOf(Integer.class));
//		Assert.assertThat("val",
//				AnyOf.anyOf(new IsEqual<String>("Val"), new IsEqual<String>("val"), new IsEqual<String>("VAL")));
//		Assert.fail("Should be unreachable code");
	}
}