import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Selenium3Sample {
	@Test
	public void chromeTest() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		//DesiredCapabilities cap = DesiredCapabilities.firefox();
	//	cap.setCapability("marionette", true);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://corporate.fromjapan.co.jp/ja/");
		
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		driver.findElement(By.id("lst-ib")).sendKeys("Selenium4");
//		driver.findElement(By.id("lst-ib")).submit();
		System.out.println("★"+driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(driver!=null) {
			System.out.println("ドライバーを終了します。");
			driver.quit();
			//driver.close();
		}
	}
	
	@Test
	public void firefoxTest2() throws InterruptedException {
		
		//System.setProperty("webdriver.gecko.driver", "./exe/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.navigate().to("http://corporate.fromjapan.co.jp/ja/");
		
		System.out.println("★"+driver.getTitle());
		if(driver!=null) {
			System.out.println("ドライバーを終了します。");
			driver.quit();
		}
	}
	@Test
	
	public void phantomTest() throws InterruptedException {
		System.setProperty("phantomjs.binary.path", "./exe/phantomjs.exe");
		
		WebDriver driver = new PhantomJSDriver();
		
		driver.navigate().to("http://corporate.fromjapan.co.jp/ja/");
		
		System.out.println("★"+driver.getTitle());
		if(driver!=null) {
			System.out.println("ドライバーを終了します。");
			driver.quit();
		}
	}
	
}