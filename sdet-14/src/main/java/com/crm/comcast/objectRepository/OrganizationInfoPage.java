package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class OrganizationInfoPage extends WebDriverUtility {
	
	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement successfullMsg;
	
	public WebElement getSuccessfulMsg()
	{
		return successfullMsg;
	}
}
