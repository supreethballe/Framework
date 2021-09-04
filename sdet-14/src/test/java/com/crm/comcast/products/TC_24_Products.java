package com.crm.comcast.products;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.PropertyFileUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

public class TC_24_Products {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		 ExcelUtility eLib = new ExcelUtility();
		 WebDriverUtility wLib = new WebDriverUtility();
		 PropertyFileUtility pLib = new PropertyFileUtility();
			/*read common data*/
		 String BROWSER = pLib.readDataFromPropertyFfile("browser");
		 String USERNAME = pLib.readDataFromPropertyFfile("username");
		 String PASSWORD = pLib.readDataFromPropertyFfile("password");
		 String URL = pLib.readDataFromPropertyFfile("url");
		 /*read test script data*/
		
		 String Pname = eLib.getExcelData("Product",11 , 2);
		 String Unitpr = eLib.getExcelData("Product", 11, 3);
		 String vat = eLib.getExcelData("Product", 11, 4);
		 String sales = eLib.getExcelData("Product", 11, 5);
		 String service = eLib.getExcelData("Product", 11, 6);
	

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
	
			//selecting exixting product from list.
			List <WebElement> noofrows = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr")); 
		       
		     int rownum = noofrows.size();	       
		     List <WebElement> element = driver.findElements(By.xpath("//a[@title=\"Products\"]"));  
		     for (int i = 0; i<element.size();i++) 
		     {
		    	if(element.get(i).getText().equalsIgnoreCase(Pname)) 
		    	{
		    		element.get(i).click();
		    		
		    	break;
		    	}
		    				
		     }
		   //clickicg on edit option.
		     driver.findElement(By.xpath("//input[@name=\"Edit\"]")).click();
	
		     driver.findElement(By.xpath("//a[text()='more currencies »']")).click();
		     driver.findElement(By.xpath("//input[@id=\"curname1\"]")).clear();
		     wLib.acceptAlert(driver);
		     driver.findElement(By.xpath("//input[@id=\"curname1\"]")).sendKeys(Unitpr);
		     
		     
//		     driver.findElement(By.xpath("//*[@id=\"unit_price\"]")).clear();
//		     driver.findElement(By.xpath("//*[@id=\"unit_price\"]")).sendKeys(Unitpr);
		   //checking if the checkboxes are selected or not and selecting if not.Also entering new data after clearing old data.
		     boolean x =driver.findElement(By.xpath("//input[@id=\"tax1_check\"]")).isSelected();
		     if(x==false)
		     driver.findElement(By.xpath("//input[@id=\"tax1_check\"]")).click();
		     driver.findElement(By.xpath("//input[@id=\"tax1\"]")).clear();
		     wLib.acceptAlert(driver);
			 driver.findElement(By.xpath("//input[@id=\"tax1\"]")).sendKeys(vat);
		    
		     boolean y = driver.findElement(By.xpath("//input[@id=\"tax2_check\"]")).isSelected();
		     if(y==false)
		     driver.findElement(By.xpath("//input[@id=\"tax2_check\"]")).click();
		     driver.findElement(By.xpath("//input[@id=\"tax2\"]")).clear();
		     wLib.acceptAlert(driver);
		     driver.findElement(By.xpath("//input[@id=\"tax2\"]")).sendKeys(sales);
		     
		     boolean z =driver.findElement(By.xpath("//input[@id=\"tax3_check\"]")).isSelected();
		     if(z==false)
		     driver.findElement(By.xpath("//input[@id=\"tax3_check\"]")).click();
		     driver.findElement(By.xpath("//input[@id=\"tax3\"]")).clear();
		     wLib.acceptAlert(driver);
		     driver.findElement(By.xpath("//input[@id=\"tax3\"]")).sendKeys(service);

		   //saving the data
//			 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
			 /*step 5: verify*/
			 String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
			 if(actSuccessFullMsg.contains(Pname)) {
				 System.out.println(Pname + "==>Product edited successfully==>PASS");
			 }else {
				 System.out.println(Pname + "==>product not edited ==>Fail");
             } 
			 /*step 6: logout*/
//			 WebElement adminWb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//			 wLib.mouseOver(driver, adminWb);
//			 driver.findElement(By.linkText("Sign Out")).click();
//	
	
	}

}
