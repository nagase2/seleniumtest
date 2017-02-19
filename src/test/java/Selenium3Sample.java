import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Selenium3Sample {
	@Test
	public void firefoxTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		//DesiredCapabilities cap = DesiredCapabilities.firefox();
	//	cap.setCapability("marionette", true);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");
		
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("Selenium4");
		driver.findElement(By.id("lst-ib")).submit();
		System.out.println("��"+driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver!=null) {
			driver.close();
		}
	}
	
//	@Test
//	public void firefoxTest2() throws InterruptedException {
//		System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
//		//DesiredCapabilities cap = DesiredCapabilities.firefox();
//	//	cap.setCapability("marionette", true);
//		WebDriver driver = new FirefoxDriver();
//		driver.navigate().to("http://www.google.com");
//		
//		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		//driver.findElement(By.id("lst-ib")).sendKeys("Selenium4");
//		//driver.findElement(By.id("lst-ib")).send;
//		System.out.println("��"+driver.getTitle());
//		if(driver!=null) {
//			driver.close();
//		}
//	}
}