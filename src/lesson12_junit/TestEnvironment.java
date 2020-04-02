package lesson12_junit;

import org.junit.*;


public class TestEnvironment {
	@BeforeClass // ���� ��� ����� �������� ������
	public static void beforeClass() {
		System.out.println("beforeClass");
	}

	@Before // ����� ������ ������
	public void before() {
		System.out.println("before");
	}

	@Test // ����1
	public void test1() {
		System.out.println("test1");
	}

	@Test // ����2
	public void test2() {
		System.out.println("test2");
	}

	@After // ����� ������� ������
	public void after() {
		System.out.println("after");
	}

	@AfterClass // ���� ��� ����� ������� ������
	public static void afterClass() {
		System.out.println("afterClass");
	}
}