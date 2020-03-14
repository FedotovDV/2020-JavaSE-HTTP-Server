package lesson08;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FilesTest {
	public static void main(String[] args) throws IOException {
		Path fileDir = Paths.get("C:\\Dev\\EclipseProject\\ru.yandex.fed3375546\\resources");
		Path fileDelete = fileDir.resolve("text-file-copy.txt");
		Path fileCopy = fileDir.resolve("text-file.txt");
		Files.deleteIfExists(fileDelete);
		Files.copy(fileCopy, fileDelete);
		List<String> list = Files.readAllLines(fileDelete);
		System.out.println(list);
		Files.delete(fileDelete);
		Files.write(fileDelete, list);
		final List<Path> foundPaths = new ArrayList<>();
		Files.walkFileTree(Paths.get(""), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				if (file.getFileName().toString().endsWith(".java")) {
					foundPaths.add(file);
				}
				return FileVisitResult.CONTINUE;
			}
		});
		for (Path fileFound : foundPaths) {
			System.out.println(fileFound);
		}
	}
}