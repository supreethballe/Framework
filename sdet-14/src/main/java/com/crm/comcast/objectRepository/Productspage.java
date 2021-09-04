package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class Productspage extends WebDriverUtility{
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Createproduct;
	
	@FindBy(name = "search_text")
	private WebElement searchText;
	
	@FindBy(name = "submit")
	private WebElement submitSearch;

    WebDriver driver;


	public Productspage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

	public WebElement getCreateproduct() {
		return Createproduct;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSubmitSearch() {
		return submitSearch;
	}
	
 public void createProd()
 {
	 Createproduct.click();
 }

}
