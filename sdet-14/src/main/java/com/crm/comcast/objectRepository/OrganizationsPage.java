package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility{
	WebDriver driver;

	public OrganizationsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title = 'Create Organization...']")
	private WebElement createOrgImage;
	
	@FindBy(name = "search_text")
	private WebElement searchText;
	
	@FindBy(name = "submit")
	private WebElement submitSearch;

	public WebElement getCreateOrgImage() {
		return createOrgImage;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSubmitSearch() {
		return submitSearch;
	}
	
 public void createOrg()
 {
	 createOrgImage.click();
 }
}
