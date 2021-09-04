package com.crm.comcast.products;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_22_Product {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		/*read common data*/
		 WebDriverUtility wLib = new WebDriverUtility();
		 PropertyFileUtility pLib = new PropertyFileUtility();
		 String BROWSER = pLib.readDataFromPropertyFfile("browser");
		 String USERNAME = pLib.readDataFromPropertyFfile("username");
		 String PASSWORD = pLib.readDataFromPropertyFfile("password");
		 String URL = pLib.readDataFromPropertyFfile("url");
		
		 /*read test script data*/
		 ExcelUtility eLib = new ExcelUtility();
		 String Mobile = eLib.getExcelData("Product", 5, 2)+ JavaUtility.getRanDomNum();
		 String Descr = eLib.getExcelData("product", 5, 3);
		 

		 /*step 1 : login to app*/
		 WebDriver driver = null;
		 if(BROWSER.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
		 }else if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equalsIgnoreCase("ie")) {
			 driver = new InternetExplorerDriver();
		 }
		 wLib.waitforPageToLoad(driver);
		 driver.get(URL);

		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();

		 /*step 3 : navigate to Products  Page*/
		 driver.findElement(By.xpath("//a[text()='Products']")).click();
		 /*step 4 : navigate to create Product Page*/
		 driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		 //Entering data.
		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Mobile);
		 driver.findElement(By.xpath("//textarea[@name=\"description\"]")).sendKeys(Descr);

		 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		 /*step 5: verify*/
		 String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		 if(actSuccessFullMsg.contains(Mobile)) {
			 System.out.println(Mobile + "==>product created successfully==>PASS");
		 }else {
			 System.out.println(Mobile + "==>product not created ==>Fail");

		 }   

		 /*step 6: logout*/
		 WebElement adminWb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wLib.mouseOver(driver, adminWb);
		 driver.findElement(By.linkText("Sign Out")).click();

	}

}
