package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	/**
	 * This method is used to load the properties from the config.properties file
	 * @return
	 */

	public Properties intializeProperties() {

		prop = new Properties();
		File proFile = new File(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");

		try {
			FileInputStream fis = new FileInputStream(proFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return prop;

	}

}
