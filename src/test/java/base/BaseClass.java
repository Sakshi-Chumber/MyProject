package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	public BaseClass() {
		
	
	  try { FileInputStream file = new FileInputStream(
	  "D:\\Eclipse\\TestNgBlaze\\src\\test\\java\\environmentalVariables\\Config.properties"
	  ); prop.load(file); } catch(FileNotFoundException e) { e.printStackTrace();
	  
	  } catch (IOException i) {
	  
	  i.printStackTrace(); }
	  
	  }
	 
	public static void initiation() {
		  
		  String Browsername = prop.getProperty("browser");
		  
		  if(Browsername.equals("Chrome")) {
		  
		  System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); driver=
		  new ChromeDriver();
		  
		  } else if(Browsername.equals("Firefox")) {
		  System.setProperty("webdriver.gecko.driver", "firefoxdriver.exe");
		  
		  } driver.manage().window().maximize(); driver.get(prop.getProperty("url"));
		  
}
		  
		 
	
	
	
}
