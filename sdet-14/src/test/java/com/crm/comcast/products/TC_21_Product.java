package com.crm.comcast.products;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_21_Product {

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
		 String Pname = eLib.getExcelData("Product",2 , 2)+ JavaUtility.getRanDomNum();
		 String unit = eLib.getExcelData("Product", 2, 3);
		 String Qtys = eLib.getExcelData("Product", 2, 4);
		 String Qtyu = eLib.getExcelData("Product", 2, 5);
		 String Reorder = eLib.getExcelData("Product", 2, 6);
		 String Group = eLib.getExcelData("Product", 2, 7);
		 String Qtyd = eLib.getExcelData("Product", 2, 8);
		
		 
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
		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Pname);
		 //selecting unit from dropdown.
		 WebElement dd = driver.findElement(By.xpath("//select[@name=\"usageunit\"]"));
		 wLib.select(dd,unit); 

		 //Entering the fetched data into respective textboxes. 
		 driver.findElement(By.xpath("//input[@id=\"qtyinstock\"]")).sendKeys(Qtys);  
		 driver.findElement(By.xpath("//input[@id=\"qty_per_unit\"]")).sendKeys(Qtyu);
		 driver.findElement(By.xpath("//input[@id=\"reorderlevel\"]")).sendKeys(Reorder);
		 driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		 //selecting group from dropdown.
		 WebElement dd1 = driver.findElement(By.xpath("//select[@name=\"assigned_group_id\"]"));
		 wLib.select(dd1,Group);
		 //		 
		 driver.findElement(By.xpath("//input[@id=\"qtyindemand\"]")).sendKeys(Qtyd);
		 //saving the data
		 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		 /*step 5: verify*/
		 String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
		 if(actSuccessFullMsg.contains(Pname)) {
			 System.out.println(Pname + "==>Product created successfully==>PASS");
		 }else {
			 System.out.println(Pname + "==>product not created ==>Fail");

		 }   

		 /*step 6: logout*/
		 WebElement adminWb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wLib.mouseOver(driver, adminWb);
		 driver.findElement(By.linkText("Sign Out")).click();




	
	}

}
