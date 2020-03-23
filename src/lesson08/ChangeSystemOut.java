package lesson08;

import java.io.*;


public class ChangeSystemOut {
	public static void main(String[] args) throws IOException {
		PrintStream consoleOut = System.out;
		System.setOut(new PrintStream(new FileOutputStream("resources\\out.txt")));
		System.out.println("Hello java!");
		System.out.println("Hello world!");
		System.out.flush();
		System.out.close();
		System.setOut(consoleOut);
		System.out.println("Hello java!");
		System.out.println("Hello world!");
	}
}