package stepBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {
	WebDriver driver;
	WebDriverWait wait;
	boolean name;
	
	@Given("I am on Homepage this url {string}")
	public void i_am_on_homepage_this_url(String string) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoblaze.com/");
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		driver.findElement(By.id("login2")).click();
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("loginusername")));
		driver.findElement(By.id("loginusername")).sendKeys("GANDALF");
		driver.findElement(By.id("loginpassword")).sendKeys("BILBO"); 
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		driver.findElement(By.cssSelector("#logInModal > div > div > div.modal-footer > button.btn.btn-primary")).click();
	}

	@Then("I should be landed on the homepage")
	public void i_should_be_landed_on_the_homepage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
		name =driver.findElement(By.id("nameofuser")).isDisplayed();
		System.out.println(name);
		
	}

	@Given("I should be logged in to his account")
	public void i_should_be_logged_in_to_his_account() {
		
		if(name==true) {
			System.out.println("User landed on his account successfully");
			
		}
		else {
			System.out.println("User was not landed on his account succesfully");
		}
	    
	}
	@When("Click on Laptops under Categories and select any product")
	public void click_on_laptops_under_categories_and_select_any_product() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[contains(text(),'Laptops')]")).click(); 
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Sony vaio i5')]")).click();
	 
	}

	@When("I should be redirected to Product description page")
	public void i_should_be_redirected_to_product_description_page() throws InterruptedException {
		//On description page - Click add to cart button
		//<a href="#" onclick="addToCart(8)" class="btn btn-success btn-lg">Add to cart</a>
		Thread.sleep(3000);
		driver.findElement(By.linkText("Add to cart")).click();
	
	}

	@When("I click on Add to Cart button")
	public void i_click_on_add_to_cart_button() {
		//On click - Alert box
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
	}

	@Then("Product should be added to cart")
	public void product_should_be_added_to_cart() {
		//Verifying Item added to cart
		driver.findElement(By.id("cartur")).click();
	  
	}
}
