package lesson12_junit;

public class QueueTest {
	private DataSet<Integer> dataSet;

	private Queue<Integer> createQueue() {
		return new Queue<Integer>(dataSet) {
		};
	}

	@Before
	@SuppressWarnings("unchecked")
	public void before() {
		dataSet = mock(DataSet.class);
	}

	@Test
	public void testAdd() {
		Queue<Integer> queue = createQueue();
		queue.add(2);
		verify(dataSet).add(2);
	}

	@Test
	public void testToArray() {
		Queue<Integer> queue = createQueue();
		when(dataSet.toArray()).thenReturn(new Integer[] { 1, 2, 3 });
		String s = queue.toString();
		verify(dataSet).toArray();
		assertEquals("[1, 2, 3]", s);
	}

	@Test
	public void testSuccessfulGet() {
		dataSet.size = 1;
		Queue<Integer> queue = createQueue();
		when(dataSet.remove(0)).thenReturn(5);
		Integer value = queue.get();
		verify(dataSet).size();
		assertEquals((Integer) 5, value);
	}
}