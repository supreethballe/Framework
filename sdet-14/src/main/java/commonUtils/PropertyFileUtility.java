package commonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	public static void main(String[] args) throws Throwable {
		
		System.out.println(ReadDataFromPropertyFfile("password"));
		
		
		
		
	}
	
	public static String ReadDataFromPropertyFfile(String Propertykey) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(Propertykey);
		return value;
	}

}
