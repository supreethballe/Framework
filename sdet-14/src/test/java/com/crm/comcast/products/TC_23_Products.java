package com.crm.comcast.products;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

public class TC_23_Products {

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
		 String Pname1 = eLib.getExcelData("Product",14, 2);
		 String Pname2 = eLib.getExcelData("Product", 14, 3)+ JavaUtility.getRanDomNum();
		 String SSD = eLib.getExcelData("Product", 14, 4);
		 String PN = eLib.getExcelData("Product", 14, 5);
		 String Mnfr = eLib.getExcelData("Product", 14, 6);
		 String PC = eLib.getExcelData("Product",14 , 7);
		 String SED = eLib.getExcelData("Product", 14, 8);
		 String Supsd = eLib.getExcelData("Product", 14, 9);
		 String Suped = eLib.getExcelData("Product", 14, 10);
		 String Vnum = eLib.getExcelData("Product", 14, 11);
		 String Vname= eLib.getExcelData("Product",14 , 12);
		 String Website = eLib.getExcelData("Product", 14, 13);
		 String Prosheet = eLib.getExcelData("Product", 14, 14);
		 String Mpn = eLib.getExcelData("Product", 14, 15);
		 String Snum = eLib.getExcelData("Product", 14, 16);
		 String Glacc = eLib.getExcelData("Product", 14, 17);
		 String SW = eLib.getExcelData("Product", 14, 18);
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
		 List <WebElement> noofrows = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr")); 
		 //selecting exixting product from list. 
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
	     //checking if the checkbox is selected or not and selecting if not.
	     boolean x =  driver.findElement(By.xpath("//input[@name=\"discontinued\"]")).isSelected();   
	     if(x==false)    
	    	 driver.findElement(By.xpath("//input[@name=\"discontinued\"]")).click();


	     //clicking on choose vendor icon
	     driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
	     //Switching control to child window.
	     wLib.switchToWindow(driver, "Vendors");

	     WebElement swb =driver.findElement(By.xpath("//select[@name='search_field']")); 
	     wLib.select(swb, SW);
	     //searching and selecting vendor from the list.		
	     driver.findElement(By.xpath("//input[@id=\"search_txt\"]")).sendKeys(Vname);		
	     driver.findElement(By.xpath("//input[@name=\"search\"]")).click();
	     driver.findElement(By.partialLinkText(Vname)).click();  
	     //Switching control back to parent window.
	     wLib.switchToWindow(driver, "Products");

	     
	     //choosing manufacturer from dropdown list.
	     WebElement d1 = driver.findElement(By.xpath("//select[@name=\"manufacturer\"]"));
	     wLib.select(d1,Mnfr );

	     //choosing product catogery from dopdown list.
	     WebElement d2 = driver.findElement(By.xpath("//select[@name=\"productcategory\"]"));
	     wLib.select(d2,PC);

		//entering data we fetched from Excel into the respective slots .
		driver.findElement(By.xpath("//input[@name=\"sales_start_date\"]")).sendKeys(SSD);
	 	driver.findElement(By.xpath("//input[@name=\"sales_end_date\"]")).sendKeys(SED);
	 	driver.findElement(By.xpath("//input[@name=\"start_date\"]")).sendKeys(Supsd);
	 	driver.findElement(By.xpath("//input[@name=\"expiry_date\"]")).sendKeys(Suped);
	 	driver.findElement(By.xpath("//input[@name=\"website\"]")).sendKeys(Website);
	 	driver.findElement(By.xpath("//input[@id=\"vendor_part_no\"]")).sendKeys(Vnum);
	 	driver.findElement(By.xpath("//input[@id=\"mfr_part_no\"]")).sendKeys(PN);
	 	driver.findElement(By.xpath("//input[@id=\"productsheet\"]")).sendKeys(Prosheet);
	 	driver.findElement(By.xpath("//input[@id=\"serial_no\"]")).sendKeys(Snum);
	
	 	WebElement d3 = driver.findElement(By.xpath("//select[@name='glacct']"));
		 wLib.select(d3,Glacc); 
		 //saving the data
		 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

		 /*step 5: verify*/
		 String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		 if(actSuccessFullMsg.contains(Pname2)) {
			 System.out.println(Pname2+ "==>Product Edited successfully==>PASS");
		 }else {
			 System.out.println(Pname2+ "==>product not Edited ==>Fail");

		 }   

		 /*step 6: logout*/
		 WebElement adminWb = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 wLib.mouseOver(driver, adminWb);
		 driver.findElement(By.linkText("Sign Out")).click();
	
	
	}

}
