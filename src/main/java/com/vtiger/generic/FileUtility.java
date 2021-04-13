package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	     
	   /**
	    * @author usha
	    * Read the data from Property file
	    * @param path of property file
	    * @param Pass key for which you want to read data
	    * @param key
	    * @throws IOException
	    */

        public String readDataFromPropFile(String path,String key) throws IOException {
        	
		FileInputStream fis= new FileInputStream(path);
		Properties prop =new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
        return value;
        
	}
}

