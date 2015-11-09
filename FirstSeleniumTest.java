package seleniumtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirstSeleniumTest {
	
	@Test
	public void testGmailLogin() throws InterruptedException{
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("pallavi.bhagade@gmail.com");
		driver.findElement(By.xpath("//input[@id='next']")).click();
		driver.findElement(By.xpath("//input[@id='Passwd']")).sendKeys("pintu@011");
		driver.findElement(By.xpath("//input[@id='signIn']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("pallavi.bhagade@gspann.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Mail from selenium test");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Sending mail from selenium test case Thanks Pallavi");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
	    driver.quit();
		
	}

}
