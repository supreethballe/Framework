package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class Productinfopage extends WebDriverUtility {

	
	WebDriver driver;

	public Productinfopage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement successfullMsg;
	
	public WebElement getSuccessfulMsg()
	{
		return successfullMsg;
	}
	
	@FindBy(name ="Edit" )
	private WebElement productinfoEdt;
	
	public void ProductinfoEdit(WebElement ProductinfoEdt)
	{
	
		ProductinfoEdt.click();
	}
	
	@FindBy(name ="Delete" )
	private WebElement productinfoDlt;
	
	public void ProductinfoDelete(WebElement ProductinfoDlt)
	{
		ProductinfoDlt.click();
	}
	
	@FindBy(name ="Duplicate" )
	private WebElement productinfoDupli;
	
	public void ProductinfoDuplicate(WebElement ProductinfoDupli)
	{
		ProductinfoDupli.click();
	}
	
}

