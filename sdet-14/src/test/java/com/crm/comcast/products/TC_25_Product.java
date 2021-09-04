package com.crm.comcast.products;

import java.util.List;
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

public class TC_25_Product {

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
		 String Pname1 = eLib.getExcelData("Product", 8, 2);
		 String Pname2 = eLib.getExcelData("Product", 8, 3)+ JavaUtility.getRanDomNum();
		 String Unit = eLib.getExcelData("Product", 8, 4);
		 String Qtys = eLib.getExcelData("Product", 8, 5);
		 String Qtyu = eLib.getExcelData("Product", 8, 6);
		 String Reorder = eLib.getExcelData("Product", 8, 7);
		 String Group = eLib.getExcelData("Product", 8, 8);
		 String Qtyd = eLib.getExcelData("Product", 8, 9);
		
		 

		 // *step 1 : login to app*/
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
		 List <WebElement> noofrows = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr")); 
		 //selecting existing product from the table.   
		 int rownum = noofrows.size();	       
		 List <WebElement> element = driver.findElements(By.xpath("//a[@title=\"Products\"]"));  
		 for (int i = 0; i<element.size();i++) 
		 {
			 if(element.get(i).getText().equalsIgnoreCase(Pname1)) 
			 {
				 element.get(i).click();

				 break;
			 }

		 }
		 //clickicg on edit option.
		 driver.findElement(By.xpath("//input[@name=\"Edit\"]")).click();

		 //clearing old name and entering new name.
		 driver.findElement(By.xpath("//input[@name='productname']")).clear();
		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Pname2);
		 //selecting unit to be used.
		 WebElement dd = driver.findElement(By.xpath("//select[@name=\"usageunit\"]"));
		 wLib.select(dd,Unit);
		 //			
		 //clearing texboxes and entering new data.
		 driver.findElement(By.xpath("//input[@id=\"qtyinstock\"]")).clear();
		 driver.findElement(By.xpath("//input[@id=\"qtyinstock\"]")).sendKeys(Qtys);  
		 driver.findElement(By.xpath("//input[@id=\"qty_per_unit\"]")).clear();
		 driver.findElement(By.xpath("//input[@id=\"qty_per_unit\"]")).sendKeys(Qtyu);
		 driver.findElement(By.xpath("//input[@id=\"reorderlevel\"]")).clear();
		 driver.findElement(By.xpath("//input[@id=\"reorderlevel\"]")).sendKeys(Reorder);
		 //selecting group from dropdown
		 driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
		 WebElement dd1 = driver.findElement(By.xpath("//select[@name=\"assigned_group_id\"]"));
		 wLib.select(dd1, Group);

		 //updating quantity in demand.
		 driver.findElement(By.xpath("//input[@id=\"qtyindemand\"]")).clear();
		 driver.findElement(By.xpath("//input[@id=\"qtyindemand\"]")).sendKeys(Qtyd);
		 //saving the changes by clicking save button.
		 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		 /*step 5: verify*/
		 String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		 if(actSuccessFullMsg.contains(Pname2)) {
			 System.out.println(Pname2 + "==>Product editd successfully==>PASS");
		 }else {
			 System.out.println(Pname2 + "==>Product not Edited ==>Fail");

		 } 
		 /*step 6: logout*/
		 WebElement adminWb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wLib.mouseOver(driver, adminWb);
		 driver.findElement(By.linkText("Sign Out")).click();


	}

}
