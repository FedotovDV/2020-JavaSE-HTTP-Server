package lesson12_junit;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Parameterized.class)
public class ParameterizedTest {
	private final Object[] array;
	private final Comparator<Object> presetComparator;
	private final Object expectedMax;

	public ParameterizedTest(Object[] array, Comparator<Object> presetComparator, Object expectedMax) {
		super();
		this.array = array;
		this.presetComparator = presetComparator;
		this.expectedMax = expectedMax;
	}

	@Test
	public void testFindMax() {
		Object actualMax = ComparatorTest.findMax(array, presetComparator);
		assertEquals(expectedMax, actualMax);
	}

	@Parameterized.Parameters
	public static List<Object[]> getParameters() {
		final Object o1 = new Object();
		final Object o2 = new Object();
		final Object max = System.identityHashCode(o1) > System.identityHashCode(o2) ? o1 : o2;
		return Arrays.asList(new Object[][] { { null, null, null }, { new Integer[] {}, null, null },
				{ new Integer[] { 1 }, null, Integer.valueOf(1) },
				{ new Integer[] { 1, 2, 3 }, null, Integer.valueOf(3) },
				{ new Integer[] { 1, 2, 3 }, Collections.reverseOrder(), Integer.valueOf(1) },
				{ new Object[] { o1, o2 }, null, max }, });
	}
}