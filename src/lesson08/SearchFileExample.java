package lesson08;

import java.io.*;
import java.util.*;

public class SearchFileExample {

	public static void main(String[] args) {
		List<File> foundFiles = new ArrayList<>();
		File rootDir = new File(".");
		findFiles(foundFiles, rootDir, ".txt");
		for (File file : foundFiles) {
			System.out.println(file);
		}
	}

	private static void findFiles(List<File> foundFiles, File rootDir, String extension) {
		if (rootDir.isDirectory()) {
			for (File file : rootDir.listFiles()) {
				if (file.isDirectory()) {
					findFiles(foundFiles, file, extension);
				} else if (file.isFile()) {
					if (file.getName().endsWith(extension)) {
						foundFiles.add(file);
					}
				}
			}
		} else {
			throw new IllegalArgumentException("rootDir should be directory: " + rootDir);
		}
	}
}