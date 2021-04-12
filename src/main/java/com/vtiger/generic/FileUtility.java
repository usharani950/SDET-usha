package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

        public void readDataFromPropFile() throws IOException {
		FileInputStream fis= new FileInputStream("../ushaautomation/commondata.properties");
		Properties prop =new Properties();
		prop.load(fis);
		
		String un=prop.getProperty("username");
		String password= prop.getProperty("password");
		String url=prop.getProperty("url");
		String browser=prop.getProperty("browser");
		

	}
}

