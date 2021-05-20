package com.crm.sdet_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.genericutility.PropertyFileUtility;

public class VtigetTest {

	
	
	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility plib = new PropertyFileUtility();
		String USERNAME = plib.readDataFromPropertyFfile("username");
		String PASSWORD = plib.readDataFromPropertyFfile("password");
		String URL = plib.readDataFromPropertyFfile("url");
		
		WebDriver driver = new FirefoxDriver();
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

	}

}
