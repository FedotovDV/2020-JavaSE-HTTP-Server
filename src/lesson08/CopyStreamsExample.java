package lesson08;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CopyStreamsExample {
	private final static String PATH = "resources\\";

	public static void main(String[] args) throws FileNotFoundException, IOException {
		try (InputStream in = new FileInputStream(PATH + "text-file.txt");
				OutputStream out = new FileOutputStream(PATH + "text-file-copy.txt")) {
			System.out.println(copy(in, out) + " bytes copied");
		}
		try (InputStream in = new URL("http://devstudy.net/").openStream();
				OutputStream out = new FileOutputStream(PATH + "devstudy.net.html")) {
			System.out.println(copy(in, out) + " bytes copied");
		}
		String text = "Some text which should be saved to file";
		try (InputStream in = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
				OutputStream out = new FileOutputStream(PATH + "text.txt")) {
			System.out.println(copy(in, out) + " bytes copied");
		}
	}

	private static long copy(InputStream in, OutputStream out) throws IOException {
		long countCopied = 0;
		byte[] buffer = new byte[4096];
		while (true) {
			int read = in.read(buffer);
			if (read == -1) {
				break;
			}
			out.write(buffer, 0, read);
			countCopied += read;
		}
		out.flush();
		return countCopied;
	}
}