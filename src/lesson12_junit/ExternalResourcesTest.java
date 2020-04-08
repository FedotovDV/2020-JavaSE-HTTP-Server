package lesson12_junit;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.junit.*;
import org.junit.rules.*;


public class ExternalResourcesTest {
	@Rule
	public final TemporaryFolder folder = new TemporaryFolder(new File("test"));
	// @Rule
	public final ExternalResource resource = new ExternalResource() {
		@Override
		protected void before() throws Throwable {
			// server.connect();
		}

		@Override
		protected void after() {
			// server.disconnect();
		}
	};

	private void writeToFile(File file) throws IOException {
		try (Writer wr = new FileWriter(file)) {
			wr.write("test");
			wr.flush();
		}
	}

	@Test
	public void testTempFile() throws IOException {
		File file = folder.newFile();
		writeToFile(file);
		List<String> list = Files.readAllLines(Paths.get(file.toURI()));
		assertEquals(1, list.size());
		assertEquals("test", list.get(0));
	}
}