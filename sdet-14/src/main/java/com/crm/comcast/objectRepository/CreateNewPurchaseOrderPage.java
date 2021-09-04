package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class CreateNewPurchaseOrderPage extends WebDriverUtility{
	
	WebDriver driver;
	
	public CreateNewPurchaseOrderPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "subject")
	private WebElement subjectEdt;
	
	@FindBy(xpath = "//input[@name='vendor_name']/following-sibling::img")
	private WebElement vendorNameWin;
	
	@FindBy(xpath = "//select[@name='search_field']")
	private WebElement searchDropdown;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(id = "searchIcon1")
	private WebElement searchProdBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchProdEdt;
	
	@FindBy(id = "qty1")
	private WebElement qtyEdt;
	
	@FindBy(name = "bill_street")
	private WebElement billStreetEdt;
	
	@FindBy(name = "ship_street")
	private WebElement shipStreetEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	//Step 4
	public WebElement getSubjectEdt() {
		return subjectEdt;
	}

	public WebElement getVendorNameWin() {
		return vendorNameWin;
	}

	public WebElement getSearchDropdown() {
		return searchDropdown;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchProdBtn() {
		return searchProdBtn;
	}

	public WebElement getSearchProdEdt() {
		return searchProdEdt;
	}

	public WebElement getQtyEdt() {
		return qtyEdt;
	}

	public WebElement getBillStreetEdt() {
		return billStreetEdt;
	}

	public WebElement getShipStreetEdt() {
		return shipStreetEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//step 5
    public void createPurchaseOrder(String subject, String serachValue, String venDorName)
    {
    	subjectEdt.sendKeys(subject);
    	vendorNameWin.click();
    	switchToWindow(driver, "Vendors");
    	select(searchDropdown, serachValue);
    	searchEdt.sendKeys(venDorName);
    	searchBtn.click();
    }
    
    public void chooseProduct(String productName)
    {
    	searchProdBtn.click();
    	switchToWindow(driver, "Product");
    	searchProdEdt.sendKeys(productName);
    	searchBtn.click();
    }
    
    public void chooseQty(String qty, String bAddress, String sAddress)
    {
    	qtyEdt.sendKeys(qty);
    	billStreetEdt.sendKeys(bAddress);
    	shipStreetEdt.sendKeys(sAddress);
    }
    
    public void save()
    {
    	saveBtn.click();
    }
    
    
    
}
