package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Step 1 create a seperate java class for a web page in an application

public class LoginPage {

//Step 2 Provide a single argumented constructor to initialise the current element
	


//step 3 Identify all the web elements corresponding to that web page


@FindBy(name="user_name")
private WebElement UserNameEdt;

@FindBy(name="user_password")
private WebElement passwordEdt;

@FindBy(id="submitButton")
private WebElement loginButton;


//step 4 provide getters to access

public WebElement getUserNameEdt()
{
return UserNameEdt;
}
 
public WebElement getPasswordEdt()
{
	return passwordEdt;
}

public WebElement getLoginButton()
{
	return loginButton;
}

//Step 5 provide a business logic to utilise these web elements

public void loginToApp(String Username, String Password)
{
	UserNameEdt.sendKeys(Username);
	passwordEdt.sendKeys(Password);
	loginButton.click();
}
}
