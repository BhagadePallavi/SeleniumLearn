package newPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class testParallelTest {
	
	WebDriver driver;
	
	@Test
	@Parameters("browser")
	public void testInDifferentBrowser(String browser){
		
		if(browser.equalsIgnoreCase("FF"))
					driver=new FirefoxDriver();
		
		else{
			System.setProperty("webdriver.chrome.driver","D:\\LearnWorkspace\\seleniumtest\\chromedriver.exe");
			
			driver=new ChromeDriver();
		}
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.findElement(By.xpath("//a[contains(text(),'Flights')]")).click();
			
driver.quit();
	}

}

