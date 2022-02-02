package testLayer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pomPackage.AddToCart;
import pomPackage.PomLogin;

public class LoginTest extends BaseClass {
	PomLogin log;
	AddToCart cart;
	
	
	public LoginTest() {
		
		super();
	}
	
	@BeforeMethod
	public void initialSetup() {
		
		initiation();
		log = new PomLogin();
		log.clicklogin();
		log.enterUname(prop.getProperty("username"));
		log.enterPasswrd(prop.getProperty("password"));
		log.loginButton();
		cart= new AddToCart();
	}
	
	@Test
	public void Login() throws InterruptedException {
		
		boolean name= log.displayname();
		System.out.println(name);
		if(name==true) {
			System.out.println("User landed on his account successfully");
			
		}
		else {
			System.out.println("User was not landed on his account succesfully");
		}
		
		
		cart.ClickOnCategory(); 
		cart.SelectLaptop(); 
		Thread.sleep(5000);
		cart.addToCart();
		 
		WebDriverWait wait= new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.alertIsPresent()); 
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		
	}

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}
