package in.developershut.bs.util.config;

import in.developershut.bs.util.FileUtil;
import in.developershut.bs.util.config.model.ConfigurationModel;

import java.util.Properties;

public class SingleConfigurationModelProvider implements ConfigurationConstants {
	
	private static ConfigurationModel configurationModel = new ConfigurationModel();
	
	private SingleConfigurationModelProvider() {}
	
	public static ConfigurationModel getConfigurationModel() throws Exception {		 
		Properties properties = FileUtil.readProperties(PROPERTIES_FILE_LOCATION);		
		/* Set configuration parameters */
		configurationModel.setTimeStampFormat(properties.getProperty(TIME_STAMP_FORMAT));
		
		/*..........*/
		return configurationModel;
	}
}
