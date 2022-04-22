package in.developershut.bs.util;

import in.developershut.bs.util.config.SingleConfigurationModelProvider;
import in.developershut.bs.util.config.model.ConfigurationModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MiscUtil {
	 
	/**
	 * @return currentTimeStamp
	 */
	public static String getCurrentTimeStamp() {	
		String currentTimeStamp = null;
		ConfigurationModel configurationModel = null;
		try {
			configurationModel = SingleConfigurationModelProvider.getConfigurationModel();
			Calendar currentDateTime = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat(configurationModel.getTimeStampFormat());
			dateFormat.setCalendar(currentDateTime);
			currentTimeStamp = dateFormat.format(currentDateTime.getTime());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return currentTimeStamp;
	}
	
	
	
	
	/**
	 * Main method for testing utility functionalities
	 * This method will be commented out after the completion of the development
	 * 
	 */
	/*public static void main(String[] args) {
		try {
			ConfigurationModel configurationModel = ConfigurationModelBuilder.getConfigurationModel();
			System.out.println(configurationModel.getTimeStampFormat());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
}
