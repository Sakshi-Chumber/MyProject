package pomPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class PomLogin extends BaseClass{
	
	WebDriverWait wait;
	
	@FindBy(id="login2") WebElement login;
	@FindBy(id="loginusername") WebElement uname;
	@FindBy(id="loginpassword") WebElement passwrd;
	@FindBy(css="#logInModal > div > div > div.modal-footer > button.btn.btn-primary")
	WebElement loginbtn;
	@FindBy(id="nameofuser") WebElement name;
	
	public PomLogin(){
		
		PageFactory.initElements(driver, this);
	}
	
	public void clicklogin() {
		
		login.click();
	}
	
	public void enterUname(String name) {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
		uname.sendKeys(name);
	}
	
	public void enterPasswrd(String passw) {
		passwrd.sendKeys(passw);
	}
	
	public void loginButton() {
		
		loginbtn.click();
	}
	
	public boolean displayname() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		return name.isDisplayed();
		
	}
	

}
