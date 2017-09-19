package com.waikato.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyRead {
	private static Properties config = null;

	private ConfigPropertyRead() { 

	}

	/**
	 * This method returns the configuration instance
	 * @return Configuration 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */ 
	
	public static Properties getInstance( ) throws FileNotFoundException, IOException {
		if(config == null){
			config = new Properties();
			config.load(new FileInputStream("src/test/resources/testdata/config.property"));
		}
		return config;
	}
}
