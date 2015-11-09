package seleniumtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class MacysBrowseTest {

	
	@Test
	public void testMacysSite() throws InterruptedException{
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://www.macys.com/");
	driver.findElement(By.xpath("//input[@id='globalSearchInputField']")).sendKeys("Jeans");
	driver.findElement(By.xpath("//input[@id='subnavSearchSubmit']")).click();
	WebElement element=driver.findElement(By.xpath("//a[@id='closeButton']"));
	  if(element.isDisplayed()){
		  element.click();
	  }
	 Thread.sleep(50000);
	System.out.println("Current URL"+driver.getCurrentUrl());
	driver.findElement(By.xpath("//h2[@id='GENDER']")).click();
	driver.findElement(By.xpath("//span[(@class='GENDER') and contains(text(),'Boys')]")).click();
	
	}
}
