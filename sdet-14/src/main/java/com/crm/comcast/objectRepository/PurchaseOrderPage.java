package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class PurchaseOrderPage extends WebDriverUtility{
	
	WebDriver driver;
	public PurchaseOrderPage(WebDriver driver) {  
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@alt='Create Purchase Order...']")
	private WebElement createPurchaseOrderImg;
	
	public WebElement getcreatePurchaseOrderImg()
	{
		return createPurchaseOrderImg;
	}

	public void createPurchaseOder()
	{
		createPurchaseOrderImg.click();
	}
}
