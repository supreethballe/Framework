package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;

public class Createproduct extends WebDriverUtility {

	WebDriver driver;

	public Createproduct(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(name ="description")
	private WebElement desrEdt;
	

	@FindBy(name = "manufacturer")
	private WebElement manfEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButtonLnk;
	
	@FindBy(xpath = "//select[@name=\"usageunit\"]")
	private WebElement UnitLnk;
	
	@FindBy(xpath = "//input[@id=\"qtyinstock\"]")
	private WebElement QtyLnk;
	
	@FindBy(xpath = "//input[@id=\"qty_per_unit\"]")
	private WebElement QtyunitLnk;
	
	@FindBy(xpath = "//input[@id=\"reorderlevel\"]")
	private WebElement reorderLnk;
	
	@FindBy(xpath = "//input[@value=\"T\"]")
	private WebElement ClickGroupLnk;
	
	
	
	
	public WebElement getproductNameEdt() {
		return productNameEdt;
	}

	public WebElement getmanfEdt() {
		return manfEdt;
	}

	public WebElement getSaveButtonLnk() {
		return saveButtonLnk;
	}

	
	public WebElement getDesrEdt() {
		return desrEdt;
	}
	public void createProduct(String ProductName)
	{
		productNameEdt.sendKeys(ProductName);
		waitForElemnetToBeVisible(driver, saveButtonLnk);
		saveButtonLnk.click();
	}
	
	public void createProductWithMnfr(String ProductName, String Manufacturer)
	{
		productNameEdt.sendKeys(ProductName);
		select(manfEdt, Manufacturer);
		waitForElemnetToBeVisible(driver, saveButtonLnk);
		saveButtonLnk.click();
	}
	public void createproductWithDesr(String ProductName, String Description)
	{
		productNameEdt.sendKeys(ProductName);
		desrEdt.sendKeys (Description);
		waitForElemnetToBeVisible(driver, saveButtonLnk);
		saveButtonLnk.click();
	}
}
