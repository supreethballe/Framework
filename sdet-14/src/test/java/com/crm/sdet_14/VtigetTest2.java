package com.crm.sdet_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericutility.JsonFileUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;

public class VtigetTest2 {

	
	
	public static void main(String[] args) throws Throwable {
		
		JsonFileUtility jlib = new JsonFileUtility();
		String USERNAME = jlib.readDataFromJSonFile("username");
		String PASSWORD = jlib.readDataFromJSonFile("password");
		String URL = jlib.readDataFromJSonFile("url");
		
		WebDriver driver = new FirefoxDriver();
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

	}

}
