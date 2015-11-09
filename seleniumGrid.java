package newPackage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class seleniumGrid {
	
	@Test
	public void testSeleniumGrid() throws MalformedURLException{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setBrowserName(BrowserType.FIREFOX);
	capabilities.setVersion("31");
	capabilities.setPlatform(Platform.WINDOWS);
	WebDriver driver = new RemoteWebDriver(new URL("http://localhost:5566/wd/hub"),capabilities);
	driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	driver.findElement(By.xpath("//a[contains(text(),'Flight Tickets')]")).click();
	driver.quit();
	}

}
