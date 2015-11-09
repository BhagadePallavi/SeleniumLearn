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

public class KohlsTest1 {
	String expectedURL="http://www.kohls.com/sale-event/mens-clothing.jsp";
	String actualURL="";
	public static String MEN_CATEGORY ="//a[@href and text()='Men']";
	WebDriver driver;
	
	@BeforeMethod
	public void openKolhsURL(){
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.kohls.com/");
	}
	@Test
	public void testMenCategory() throws InterruptedException{
	driver.findElement(By.xpath(MEN_CATEGORY)).click();
	actualURL=driver.getCurrentUrl();
	Assert.assertEquals(actualURL,expectedURL,"Expected Url for men category is not found!!");
	
	}
	
	@AfterMethod
	public void closeKolhsURL(){
		actualURL="";
		expectedURL="";
		driver.quit();
	}
}
