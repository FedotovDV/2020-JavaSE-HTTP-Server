package lesson08;

import java.io.*;
import java.util.Properties;



public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		try (InputStream in = PropertiesTest.class.getClassLoader().getResourceAsStream("server.properties")) {
			prop.load(in);
		}
		System.out.println("wepapp.static.dir.root=" + prop.getProperty("wepapp.static.dir.root"));
		System.out.println("wepapp.static.notfound=" + prop.getProperty("wepapp.static.notfound"));
	}
}