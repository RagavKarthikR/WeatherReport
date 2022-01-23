package UpMan.WeatherReport;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Stepdefinition extends utilites {

	@Given("^Initiate the chromedriver$")
	public void initiate_the_chrome_driver(){
	    System.setProperty("webdriver.chrome.driver", driverpath);
	  
}
	@When("^Get the weather report from Web and API$")
	public void navigate_to_weather_report_url() throws Throwable {
		read_weatherreportWeb();
		read_weatherreportApi();
	}

	@Then("^Compare the whether report$")
	public void readWeather() throws Throwable {
		weathercomaprision();
       
}


}