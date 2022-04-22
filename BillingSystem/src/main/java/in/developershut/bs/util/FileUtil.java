package in.developershut.bs.util;

import java.io.InputStream;
import java.util.Properties;

public class FileUtil {
	
	public static Properties readProperties(String fileLocation) throws Exception {
		Properties properties = null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream propertiesFileInputStream = classLoader.getResourceAsStream(fileLocation);
		properties = new Properties();
		properties.load(propertiesFileInputStream);
		return properties;
	}
}
