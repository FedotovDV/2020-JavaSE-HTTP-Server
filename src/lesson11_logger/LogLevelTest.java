package lesson11_logger;

import java.io.*;
import java.util.*;
import org.slf4j.*;

public class LogLevelTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogLevelTest.class);

	private static Integer getConfigParamFromClasspathResource() {
		LOGGER.trace("Try to read config param from classpath resource 'config.properties'");
		Properties prop = new Properties();
		try (InputStream in = LogLevelTest.class.getClassLoader().getResourceAsStream("config.properties")) {
			if (in != null) {
				prop.load(in);
			} else {
				LOGGER.warn("Classpath resource 'config.properties' not found");
			}
		} catch (IOException e) {
			LOGGER.warn("Can't load properties from classpath resource 'config.properties': " + e.getMessage(), e);
		}
		String configParam = prop.getProperty("config.param");
		if (configParam != null) {
			try {
				int value = Integer.parseInt(configParam);
				LOGGER.debug("Retrieved config param from classpath resource 'config.properties'");
				return value;
			} catch (NumberFormatException e) {
				LOGGER.warn("Property 'config.param' from classpath resource 'config.properties' is invalid: {}",
						configParam);
			}
		} else {
			LOGGER.debug("Config param 'config.param' not found in the classpath resource 'config.properties'");
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			int configParam = getConfigParam();
			LOGGER.info("Config param is {}", configParam);
		} catch (IllegalStateException e) {
			LOGGER.error("Config param not found: " + e.getMessage(), e);
		}
	}

	private static int getConfigParam() {
		Integer param = getConfigParamFromSystemEnvironment();
		if (param == null) {
			param = getConfigParamFromClasspathResource();
		}
		throw new IllegalStateException("'config.param' is not avaialable");
	}

	private static Integer getConfigParamFromSystemEnvironment() {
		LOGGER.trace("Try to read config param from System property");
		String configParam = System.getProperty("config.param");
		if (configParam != null) {
			try {
				int value = Integer.parseInt(configParam);

				LOGGER.debug("Retrieved config param from System property 'config.param'");
				return value;
			} catch (NumberFormatException e) {
				LOGGER.warn("System property 'config.param' is invalid: {}", configParam);
			}
		} else {
			LOGGER.warn("Config param 'config.param' not found in the System environment");
		}
		return null;
	}
}
