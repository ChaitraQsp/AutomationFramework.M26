package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart {
	
	public static void main(String[] args) {
		
		//Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Step 2: Load the Application
		driver.get("https://www.saucedemo.com/");
		
		//Step 3: login To Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//Step 4: Click on a Product - Sauce Labs Bolt T-shirt
		WebElement productEle = driver.findElement(By.xpath("//div[.='Sauce Labs Bolt T-Shirt']"));
		String pAddedToCart = productEle.getText();
		productEle.click();
	
		//Step 5: Add the Product To Cart
		driver.findElement(By.id("add-to-cart")).click();
		
		//Step 6: Navigate to Cart
		driver.findElement(By.id("shopping_cart_container")).click();
		
		//Step 7: Validate the product in Cart
		String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(pInCart.equals(pAddedToCart))
		{
			System.out.println("PASS");
			System.out.println(pInCart);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Step 8: Logout of App
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		
	}

}
