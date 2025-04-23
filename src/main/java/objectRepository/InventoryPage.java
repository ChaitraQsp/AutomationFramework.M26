package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility{
	

	//Declaration
	@FindBy(className = "product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLnk;
	
	@FindBy(id = "shopping_cart_container")
	private WebElement cartContainerBtn;
	
	
	//Intialization
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    //Utilization
	public WebElement getSortDropDown() {
		return sortDropDown;
	}

    public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLnk() {
		return logoutLnk;
	}

	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}
	
	//Business Library
	
	/**
	 * This method will click on a product and return the details to caller
	 * @param driver
	 * @param productname
	 * @return
	 */
	public String clickOnAProduct(WebDriver driver, String productname)
	{
		WebElement ele = driver.findElement(By.xpath("//div[.='"+productname+"']"));
		String productdetails = ele.getText();
		ele.click();
		
		return productdetails;
	}
	
	/**
	 * This method will click on lowest priced product and return the product
	 * details to caller
	 * @param driver
	 * @param ProductName
	 * @param sortOption
	 * @return
	 */
	public String clickOnLowestPriceProduct(WebDriver driver, String ProductName, String sortOption)
	{
		handleDropDown(sortDropDown, sortOption);
		WebElement ele = driver.findElement(By.xpath("//div[.='"+ProductName+"']"));
		String productDetails = ele.getText();
		ele.click();
		
		return productDetails;
	}
	
	/**
	 * This method will perform logout operation
	 */
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLnk.click();
	}
	
	/**
	 * This method will click on cart container button
	 */
	public void clickOnCartContainer()
	{
		cartContainerBtn.click();
	}
	
}
