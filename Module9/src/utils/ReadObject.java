package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {
	
	Properties p = new Properties();
	
	public Properties getObjectRepository() throws IOException {
		
		String filePath = System.getProperty("user.dir") + "\\src\\objects\\object.properties";
		InputStream inputStream = new FileInputStream(new File(filePath));
		p.load(inputStream);
		return p;
		
	}

}
