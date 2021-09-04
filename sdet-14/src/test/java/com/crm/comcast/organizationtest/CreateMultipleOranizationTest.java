package com.crm.comcast.organizationtest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.JavaUtility;
/**
 * 
 * @author Nitheesha
 *
 */
@Listeners(com.crm.comcast.genericutility.ListnersIMP.class)
public class CreateMultipleOranizationTest extends BaseClass {

	@DataProvider
	public Object[][] getData() throws Throwable {
		return eLib.getExcelData("CreateMultipleOrg");
	}

	@Test(dataProvider = "getData", groups = {"Regression"})
	public void createMultipleOrgTest(String orgName,String industry,String phoneNumber) {

		orgName=orgName+JavaUtility.getRanDomNum();
		/*step 1 : navigate to Orgnization Page*/ 
		driver.findElement(By.linkText("Organizations")).click();

		/*step 2 : navigate to create Orgnization Page*/ 
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		/*step 3 : create new Orgnization*/
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		

		// step 4: specify the industry
		WebElement industryType= driver.findElement(By.name("industry"));
		wLib.select(industryType, industry);

		// step 5: add phone number
		driver.findElement(By.id("phone")).sendKeys(phoneNumber);
		
		//step 6: save the orgnization
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/*step 7: create new Verify*/  
		String actSuccessFullMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean isOrgPresent=actSuccessFullMsg.contains(orgName);
		Assert.assertTrue(isOrgPresent);
	}
}
