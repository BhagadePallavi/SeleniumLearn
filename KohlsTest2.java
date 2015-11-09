package seleniumtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KohlsTest2 {
	String expectedURL="";
	String actualURL="";
	public static String MEN_CATEGORY ="//a[@href and text()='Men']";
	public static String SEARCH_BOX="//input[@id='search']";
	public static String SEARCH_SUBMIT="//input[@type='submit' and @name='submit-search']";
	WebDriver driver;
	
	@BeforeClass
	public void openWebdriver(){
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	@AfterClass
	public void closeWebdriver(){
		driver.quit();
	}
	@BeforeMethod
	public void openKolhsURL(){
		
		driver.get("http://www.kohls.com/");
	}
	@Test
	public void testMenCategory() throws InterruptedException{

	driver.findElement(By.xpath(MEN_CATEGORY)).click();
	actualURL=driver.getCurrentUrl();
	expectedURL="http://www.kohls.com/sale-event/mens-clothing.jsp";
	Assert.assertEquals(actualURL,expectedURL,"Expected Url for men category is not found!!");
	
	}
	
	@AfterMethod
	public void closeKolhsURL(){
	
		actualURL="";
		expectedURL="";
	}
	
	@Test
	public void testSearch() throws InterruptedException{

	driver.findElement(By.xpath(SEARCH_BOX)).sendKeys("Jeans");
	driver.findElement(By.xpath(SEARCH_SUBMIT)).click();
	actualURL=driver.getCurrentUrl();
	expectedURL="http://www.kohls.com/search.jsp?search=Jeans&submit-search=web-regular";
	Assert.assertEquals(actualURL,expectedURL,"Expected Url for Jenas is not found!!");
	
	}
}
