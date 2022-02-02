package stepBlaze;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUp {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User must be on Homepage url {string}")
	public void user_must_be_on_homepage_url(String string) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(string); 
		
	}
		
	@When("User click on Sign up")
	public void user_click_on_sign_up() {
		 driver.findElement(By.id("signin2")).click(); 
		 
	}
	   
	@When("Enter valid (.*) and (.*)$")
	public void enter_valid_username_and_password(String username, String password) {
		//WebElement uname = driver.findElement(By.id("sign-username"));
		//Handling Exception ELEMENT NOT INTERACTABLE  by using WEBDRIVER WAIT
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
		driver.findElement(By.id("sign-username")).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-password")));
		driver.findElement(By.id("sign-password")).sendKeys(password); 
		
	}
	
	@When("Clicks on Sign up button")
	public void clicks_on_sign_up_button() {
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click(); 
		
	}
	  
	@Then("Dialog box should be displayed {string}")
	public void dialog_box_should_be_displayed(String string)  {
		// Handling Exception No such alert present by using WEBDRIVER WAIT
		  wait.until(ExpectedConditions.alertIsPresent()); 
		  Alert alert = driver.switchTo().alert(); //displaying alert text
		  System.out.println(alert.getText()); // clicking on "ok" button
		  alert.accept();
		 	
	}
}
