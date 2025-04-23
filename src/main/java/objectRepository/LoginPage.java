package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule 1- create a seperate POM class
	
	//Declaration
	//Rule 2: Identify all web elements using annotations
	@FindBy(id = "user-name") 
	private WebElement usernameEdt; 
	
	//Auto Healing Process - if first locator is not able to identify the web element 
	//automatically then @findAll will shift to another locator for identifying the web element
	@FindAll({@FindBy(id = "password"),@FindBy(name = "password")})//single web element with multiple locators - OR operator - 
	private WebElement passwordEdt;
	
//	@FindBys({@FindBy(id = "password"),@FindBy(name = "password")})//single web element with multiple locators - AND operator - 
//	private WebElement passwordEdt;
	
	@FindBy(className = "submit-button")
	private WebElement loginBtn;
	
	//Rule 3: Create a constructor to initialize webelements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getters to Access the web elements
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library - Generic method - related to Application
	
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password )
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	

	
}
