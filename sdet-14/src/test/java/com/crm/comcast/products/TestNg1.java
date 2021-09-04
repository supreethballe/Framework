package com.crm.comcast.products;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.objectRepository.Createproduct;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.OrganizationInfoPage;
import com.crm.comcast.objectRepository.OrganizationsPage;
import com.crm.comcast.objectRepository.Productinfopage;
import com.crm.comcast.objectRepository.Productspage;

public class TestNg1 extends BaseClass {

	@Test(groups = "smokeTest")
	  public void product()throws Throwable{

		String Mobile = eLib.getExcelData("Product", 5, 2)+ JavaUtility.getRanDomNum();
		String Descr = eLib.getExcelData("product", 5, 3);

		/*step 3 : navigate to Products  Page*/
		HomePage hp = new HomePage(driver);
		hp.navigateproducts();

		//	 driver.findElement(By.xpath("//a[text()='Products']")).click();

		/*step 4 : navigate to create Product Page*/
		Productspage pro = new Productspage(driver);
		pro.createProd();

		// driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		//Entering data.

		Createproduct cp = new Createproduct(driver);
		cp .createproductWithDesr(Mobile, Descr);

		//		 /*step 5: verify*/

		Productinfopage pif = new Productinfopage(driver);
		String actSuccessFullMsg = pif.getSuccessfulMsg().getText();
		Assert.assertTrue(actSuccessFullMsg.contains(Mobile));


	}
}
