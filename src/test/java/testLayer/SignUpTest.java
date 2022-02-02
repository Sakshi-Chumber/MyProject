package testLayer;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pomPackage.PomSignUp;

public class SignUpTest extends BaseClass {
	PomSignUp obj;	
	
	public SignUpTest() {
		super();       }
	
	@BeforeMethod
	public void initsetup() {
		
		initiation();
		obj = new PomSignUp();       	}

	@Test(priority=1)
	public void Title() {
		String actual= obj.verifyTitle();
		Assert.assertEquals(actual, "STORE"); }
	
	  @Test(priority=2)
	  public void Signup() { 
		  obj.ClickSignUp();    // Clicking on SignUp link from Navigation bar
		  obj.typeUsername(prop.getProperty("username")); 
		  obj.typePassword(prop.getProperty("password")); 
		  obj.CreateUser(); 
		  WebDriverWait wait= new WebDriverWait(driver, 40);
		  wait.until(ExpectedConditions.alertIsPresent()); 
		  Alert alert = driver.switchTo().alert();
		  System.out.println(alert.getText());
		  alert.accept();
	  }
	  
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
