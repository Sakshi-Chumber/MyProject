package pomPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class AddToCart extends BaseClass{
	// Object Repository
	
	@FindBy(xpath="//*[contains(text(),'Laptops')]") WebElement clickOnLaptop;
	@FindBy(xpath="//*[contains(text(),'Sony vaio i5')]") WebElement ChooseLaptop;
	@FindBy(linkText="Add to cart") WebElement AddItem;
	
	//Initializing Elements
	
	public AddToCart() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnCategory() {
		
		clickOnLaptop.click();
	}
	
	public void SelectLaptop() {
		
		ChooseLaptop.click();
	}
	
	public void addToCart() {
		
		AddItem.click();
	}
}
