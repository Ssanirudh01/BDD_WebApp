package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	WebDriver driver;

	@Given("^Login should be available$")
	public void login_should_be_available() {
		 System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");  //"E:\\geckodriver-v0.20.1-win64\\geckodriver.exe"
		  driver= new FirefoxDriver();
		  driver.get("http://http://ec2-18-222-145-43.us-east-2.compute.amazonaws.com:8090/TestWebapp");
		  
	    
	}
	String breakpoint;

	@When("^Validate Login application$")
	public void validate_Login_application() {
		driver.findElement(By.name("uname")).sendKeys("admin");
		  driver.findElement(By.name("psw")).sendKeys("pass");
		  driver.findElement(By.xpath("//*[@type='submit']")).click();
		  System.out.println("Sucessful");
	    
	}

	@Then("^Login should be successful$")
	public void login_should_be_successful() {
		breakpoint=driver.findElement(By.tagName("h2")).getText();
		  Assert.assertEquals(breakpoint, "Prolearn");
	    
	}

}
