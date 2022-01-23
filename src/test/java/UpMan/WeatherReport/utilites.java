package UpMan.WeatherReport;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class utilites {

	  public static WebDriver driver;
	  public static String driverpath= System.getProperty("user.dir") + "//" + "src//test//resources//"	+ "chromedriver96.exe";
	  public static String url ="https://www.accuweather.com/";
	  public static float finaltempweb ,finaltempAPI;
	  
	  @SuppressWarnings("deprecation")
	public static void read_weather() throws Throwable {
		  
		  Thread.sleep(10000);
		  WebElement temp =driver.findElement(By.xpath("//div[@class='temp']"));
		  
		  Assert.assertEquals(true, temp.isDisplayed());
		  String x = temp.getText();
		  x = x.substring(0, 2);
	
		  
		  finaltempweb = Integer.parseInt(x);
		  System.out.println("Temparture in web site " + finaltempweb);
		  driver.close();
		 
	  }
	  
	  
	  public static void read_weatherreportWeb() throws Throwable {
		    driver = new ChromeDriver();
			driver.get(url);
		    driver.manage().window().maximize();
		  Assert.assertEquals(true, driver.findElement(By.className("header-logo")).isDisplayed());
		    Assert.assertEquals(true, driver.findElement(By.className("search-input")).isDisplayed()); 
		    //Search for country
		    WebElement search = driver.findElement(By.name("query"));
		    search.sendKeys("Singapore, Central Singapore" +  Keys.ENTER);
		    
			  Thread.sleep(10000);
		    
		    if(driver.findElement(By.className("cur-con-weather-card__title")).isDisplayed()) {
		    	read_weather();
		    	
		    }else {
		    	Assert.fail("Weather Reporting Page is not loaded");
		    }
	  }
	  
	  public static void read_weatherreportApi() {
		  Response res =  (Response) given()
			         .contentType(ContentType.JSON)
			         .pathParam("city name", "Singapore, Central Singapore")
			         .pathParam("APIKey", "7fe67bf08c80ded756e598d6f8fedaea")
			         .when()
			         .get("https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={APIKey}");
			        			
				  JsonPath jsonPathEvaluator = res.jsonPath();				  
				  finaltempAPI = jsonPathEvaluator.get("main.temp");
				  System.out.println("Temparture in API " +finaltempAPI);
		  
	  }
	  
	  public static void weathercomaprision() {
		  
		  float diff = finaltempAPI - finaltempweb;
		  Assert.assertEquals(true, diff<30);

		  
	  }
}



