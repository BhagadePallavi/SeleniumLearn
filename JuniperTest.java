package seleniumtest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JuniperTest {
	WebDriver driver;
	@BeforeMethod
	public void setupBrowser()
	{
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.juniper.net/us/en/");	
	}
	@Test
	public void testJuniperSite() throws InterruptedException{

		WebElement we=driver.findElement(By.xpath("//div[@class='icon-logo icon']"));
		
		System.out.println("value of tag "+we.getTagName());
		Assert.assertTrue(we.isDisplayed(), "Juniper page is not opened successfully!!");
		
		List<WebElement> elementList =driver.findElements(By.xpath("//a[@href][text()]"));
		
		for(WebElement element : elementList){
		     System.out.println("" + element.getText());
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
