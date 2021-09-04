package com.crm.comcast.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.Productinfopage;
import com.crm.comcast.objectRepository.Productspage;

public class TestNG extends BaseClass{

	
	@Test(groups = "smokeTest")
  public void product()throws Throwable{
		
		 String Pname = eLib.getExcelData("Product",2 , 2)+ JavaUtility.getRanDomNum();
		 String unit = eLib.getExcelData("Product", 2, 3);
		 String Qtys = eLib.getExcelData("Product", 2, 4);
		 String Qtyu = eLib.getExcelData("Product", 2, 5);
		 String Reorder = eLib.getExcelData("Product", 2, 6);
		 String Group = eLib.getExcelData("Product", 2, 7);
		 String Qtyd = eLib.getExcelData("Product", 2, 8);

	 /*step 3 : navigate to Products  Page*/
			HomePage hp = new HomePage(driver);
			hp.navigateproducts();
		 
		// driver.findElement(By.xpath("//a[text()='Products']")).click();
	 /*step 4 : navigate to create Product Page*/
			Productspage pro = new Productspage(driver);
			pro.createProd();
	//driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
	 
	//inserting data into boxes	 
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
	 
		Productinfopage pif = new Productinfopage(driver);
		String actSuccessFullMsg = pif.getSuccessfulMsg().getText();
		Assert.assertTrue(actSuccessFullMsg.contains(Pname));
	 
//	 String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
//	 if(actSuccessFullMsg.contains(Pname)) {
//		 System.out.println(Pname + "==>Product created successfully==>PASS");
//	 }else {
//		 System.out.println(Pname + "==>product not created ==>Fail");
//
//	   }  
//	 
	}
   
//	@Test(groups = "smokeTest")
//	  public void product2()throws Throwable{
//	
//		String Mobile = eLib.getExcelData("Product", 5, 2)+ JavaUtility.getRanDomNum();
//		 String Descr = eLib.getExcelData("product", 5, 3);
//		
//		 /*step 3 : navigate to Products  Page*/
//		 driver.findElement(By.xpath("//a[text()='Products']")).click();
//		 /*step 4 : navigate to create Product Page*/
//		 driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
//		 //Entering data.
//		 driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Mobile);
//		 driver.findElement(By.xpath("//textarea[@name=\"description\"]")).sendKeys(Descr);
//
//		 driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
//		 /*step 5: verify*/
//		 String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
//		 if(actSuccessFullMsg.contains(Mobile)) {
//			 System.out.println(Mobile + "==>product created successfully==>PASS");
//		 }else {
//			 System.out.println(Mobile + "==>product not created ==>Fail");
//		
//		 }
//	}
	
	
}
