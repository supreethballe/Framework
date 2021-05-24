package com.crm.comcast.purchaseordertest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;

/**
 * 
 * @author Deepak
 *
 */
public class CreatePurcahseOrderTest {
	
	public static void main(String[] args) throws Throwable {
		/*read common data*/
		 PropertyFileUtility pLib = new PropertyFileUtility();
		 String BROWSER = pLib.readDataFromPropertyFfile("browser");
		 String USERNAME = pLib.readDataFromPropertyFfile("username");
		 String PASSWORD = pLib.readDataFromPropertyFfile("password");
		 String URL = pLib.readDataFromPropertyFfile("url");

		
		/*read test script data*/
		 ExcelUtility eLib = new ExcelUtility();
		 String subject = eLib.getExcelData("po", 1, 2);
		 String venDorName = eLib.getExcelData("po", 1, 3);
		 String serachValue = eLib.getExcelData("po", 1, 4);
		 String bAddress = eLib.getExcelData("po", 1, 5);
		 String sAddress = eLib.getExcelData("po", 1, 6);
		 String productName = eLib.getExcelData("po", 1, 7);
		 String qty = eLib.getExcelData("po", 1, 8);

		 
		/*step 1 : login to app*/
		 WebDriver driver = null;
		   if(BROWSER.equalsIgnoreCase("firefox")) {
		       driver = new FirefoxDriver();
	      }else if(BROWSER.equalsIgnoreCase("chrome")) {
	    	   driver = new ChromeDriver();
	      }else if(BROWSER.equalsIgnoreCase("ie")) {
	    	   driver = new InternetExplorerDriver();
	      }
		   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get(URL);
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();
	        
		 
		/*step 2 : navigate to purchase Oder Page*/ 
		   Actions act = new Actions(driver);
		   act.moveToElement(driver.findElement(By.linkText("More"))).perform();
		   driver.findElement(By.linkText("Purchase Order")).click();
		  
		/*step 3 : navigate to create purchase Oder Page*/ 
		   driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		   
		/*step 4 : create new purchase Oder Page*/ 
		   driver.findElement(By.name("subject")).sendKeys(subject);
		   driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img")).click();
		   /*Switch to child browser*/
		   String parentWindowID = driver.getWindowHandle();
		   Set<String> set = driver.getWindowHandles();
		   Iterator<String> it = set.iterator();
            for(int i=0; i<set.size(); i++) {
            	 String cusrrentWindowID = it.next();
            	 driver.switchTo().window(cusrrentWindowID);
            	 String actWindowTitle = driver.getTitle();

	            	 if(actWindowTitle.contains("Vendors")) {	            		 
	            		 break;
	            	 }
            	
             }

		  WebElement swb =driver.findElement(By.xpath("//select[@name='search_field']")); 
		  Select sel =new Select(swb); sel.selectByVisibleText(serachValue);
		 
		 driver.findElement(By.name("search_text")).sendKeys(venDorName);
		 driver.findElement(By.name("search")).click();
		 driver.findElement(By.linkText(venDorName)).click();
		   /*Switch back to parent browser*/
		   driver.switchTo().window(parentWindowID);
		   
		   //select product 
		   driver.findElement(By.id("searchIcon1")).click();
		   Set<String> set1 = driver.getWindowHandles();
		   Iterator<String> it1 = set1.iterator();
            for(int i=0; i<set1.size(); i++) {
            	 String cusrrentWindowID = it1.next();
            	 driver.switchTo().window(cusrrentWindowID);
            	 String actWindowTitle = driver.getTitle();

	            	 if(actWindowTitle.contains("Products")) {	            		 
	            		 break;
	            	 }
            	
             }
   		 driver.findElement(By.name("search_text")).sendKeys(productName);
   		 driver.findElement(By.name("search")).click();
   		 driver.findElement(By.linkText(productName)).click();
		   /*Switch back to parent browser*/
		   driver.switchTo().window(parentWindowID);
		  driver.findElement(By.id("qty1")).sendKeys(qty);
		  
		  driver.findElement(By.name("bill_street")).sendKeys(bAddress);
		  driver.findElement(By.name("ship_street")).sendKeys(sAddress);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		   
		/*step 5: verify*/
		  String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		  if(actSuccessFullMsg.contains(subject)) {
			  System.out.println(subject + "==>purchase order created successfully==>PASS");
		  }else {
			  System.out.println(subject + "==>purchase order not created ==>Fail");

		  }
		/*step 6: logout*/
		  Actions act2 = new Actions(driver);
		  act2.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		  driver.findElement(By.linkText("Sign Out")).click();
		  
		  
		 
	}

}


