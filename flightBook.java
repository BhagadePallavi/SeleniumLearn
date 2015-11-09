package newPackage;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class flightBook {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void openBrowser(){
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@BeforeMethod
	public void setUpBrowser(){
	
	driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	}
	
	@Test
		public void testSearchFlight() throws InterruptedException{
		  String winHandleParent = driver.getWindowHandle();
		  System.out.println("parent window handler"+winHandleParent);
		  driver.findElement(By.xpath("//a[contains(text(),'Flight Tickets')]")).click();
		  Thread.sleep(2000);
          Set<String> allWindowHandles = driver.getWindowHandles();
		  System.out.println(allWindowHandles.size());
		  System.out.println(driver.getTitle());
		  for(String winHandle : allWindowHandles){
		  
		   if(!winHandle.equalsIgnoreCase(winHandleParent)){
			   driver.switchTo().window(winHandle);
			   System.out.println(driver.getTitle());
		   		       break;
		
		   }
	}
		  driver.findElement(By.id("origin")).sendKeys("Delhi");
		  driver.findElement(By.xpath("//a[contains(text(),'Delhi')]")).click();
		  driver.findElement(By.id("destination")).sendKeys("Jaipur");
		  driver.findElement(By.xpath("//a[contains(text(),'Jaipur')]")).click();
		  driver.findElement(By.xpath("//div[@class='whencontainerfld']/img")).click();  
		  driver.findElement(By.xpath("//a[contains(text(),'1')]")).click();
		  Select adults = new Select(driver.findElement(By.id("noOfAdult")));
		  adults.selectByValue("2");
		  
		  Select children = new Select(driver.findElement(By.id("noOfChild")));
		  children.selectByValue("1");
		  driver.findElement(By.xpath("//div[@id='showdometic']/div[@class='srchbtn']")).click();
		  driver.findElement(By.xpath("//a[@id='minPrice']/img")).click();
		  List<WebElement> flights =driver.findElements(By.xpath("//div[@id='flightListResult']/div"));
		  System.out.println("Total Flights found for destination are "+ flights.size());
	
	}
	@AfterMethod
	public void tearDown(){
		  driver.close();
		
	}
	@AfterTest
	public void closeBrowser(){
		  driver.quit();
		
	}

}
