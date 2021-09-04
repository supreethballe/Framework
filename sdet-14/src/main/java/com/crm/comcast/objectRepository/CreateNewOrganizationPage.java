package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility{
	
	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButtonLnk;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryEdt() {
		return industryEdt;
	}

	public WebElement getSaveButtonLnk() {
		return saveButtonLnk;
	}

	public void createOrganization(String OrgName)
	{
		orgNameEdt.sendKeys(OrgName);
		waitForElemnetToBeVisible(driver, saveButtonLnk);
		saveButtonLnk.click();
	}
	
	public void createOrgWithIndustry(String OrgName, String industry)
	{
		orgNameEdt.sendKeys(OrgName);
		select(industryEdt, industry);
		waitForElemnetToBeVisible(driver, saveButtonLnk);
		saveButtonLnk.click();
	}
}
