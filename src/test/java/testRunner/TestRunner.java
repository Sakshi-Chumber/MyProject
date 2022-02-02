package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "D:\\Eclipse\\BlazeProject\\src\\test\\java\\features",
				 glue= {"stepBlaze"},
				 plugin= {"pretty", "html:target/Htmlreports.json"},
				 monochrome=true)


public class TestRunner {

}
