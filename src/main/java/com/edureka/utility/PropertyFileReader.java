package com.edureka.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertyFileReader {
	static String configFile=System.getProperty("user.dir")+"/input/config.properties";;
	public PropertyFileReader() {
		
	}
	public static String getProperty(String key) throws IOException 
	 {
	 	Properties property = new Properties();
	 	try {
	 		property.load(new FileInputStream(configFile));
	 	} catch (IOException e) {
	 		System.out.println("Unable to load Data");
	 	}
	 	return property.getProperty(key);
	 }
	
	
	public static String setproperty(String key,String value) throws ConfigurationException {
		PropertiesConfiguration config=new PropertiesConfiguration(configFile);
		config.setProperty(key, value);
		config.save();
		return value;
	}
}
