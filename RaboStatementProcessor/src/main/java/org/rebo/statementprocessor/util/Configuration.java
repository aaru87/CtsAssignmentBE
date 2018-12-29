package org.rebo.statementprocessor.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class Configuration {

	/**
	 * The instance of Configuration that this Class is storing
	 */
	private static Configuration instance = null;

	private Properties prop = new Properties();

	private String propFileName = "config.properties";

	private InputStream inputStream;
	private final static Logger logger = Logger.getLogger(Configuration.class);

	private Configuration() {
		boolean result = this.loadConfig();
	}

	public static Configuration getInstance() {
		if (Configuration.instance == null) {
			Configuration.instance = new Configuration();
		}

		return Configuration.instance;
	}

	private boolean loadConfig() {
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (IOException ex) {
			logger.log(Level.ERROR, null, ex);
			return false;
		}

		return true;
	}

	public String getPropertyByKey(String key) {
		return this.prop.getProperty(key);
	}
}
