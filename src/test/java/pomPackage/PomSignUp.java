package pomPackage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class PomSignUp extends BaseClass {
	
	WebDriverWait wait;
	//Object Repository
	
	@FindBy(id="signin2") WebElement SignUp;
	@FindBy(id="sign-username") WebElement Username;
	@FindBy(id="sign-password") WebElement Password;
	@FindBy(xpath="//*[@id='signInModal']/div/div/div[3]/button[2]") WebElement button;
	
	// Initializing Element
	public PomSignUp() {
		
		PageFactory.initElements(driver, this);	}
	
	public void ClickSignUp() {
		
		SignUp.click();	}
	
	public void typeUsername(String username) {
		
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
		Username.sendKeys(username);
	}
	
	public void typePassword(String password) {
		
		Password.sendKeys(password);}
	
	public void CreateUser() {
		button.click(); }
	
	public String verifyTitle() {
		return driver.getTitle();
	}

}
