import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

public class Selenium3Sample {
	// @Test
	public void chromeTest() throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "./exe/chromedriver.exe");
		// DesiredCapabilities cap = DesiredCapabilities.firefox();
		// cap.setCapability("marionette", true);
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://corporate.fromjapan.co.jp/ja/");

		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// driver.findElement(By.id("lst-ib")).sendKeys("Selenium4");
		// driver.findElement(By.id("lst-ib")).submit();
		System.out.println("★" + driver.getTitle());

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (driver != null) {
			System.out.println("ドライバーを終了します。");
			driver.quit();
			// driver.close();
		}
	}

	@Test
	public void firefoxTest2() throws InterruptedException {

		// System.setProperty("webdriver.gecko.driver",
		// "./exe/chromedriver.exe");
		WebDriver driver = new FirefoxDriver();

		driver.navigate().to("http://corporate.fromjapan.co.jp/ja/");

		System.out.println("★" + driver.getTitle());
		if (driver != null) {
			System.out.println("ドライバーを終了します。");
			driver.quit();
		}
	}

	@Test
	public void phantomTest() throws InterruptedException {
		// System.setProperty("phantomjs.binary.path", "./exe/phantomjs.exe");

		WebDriver driver = new PhantomJSDriver();

		driver.navigate().to("http://corporate.fromjapan.co.jp/ja/");
		
		// driver.manage().window().setSize(new Dimension(1200,900));
		driver.manage().window().maximize();
		 
		 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("./phantomtest.png");
		try {
			Files.move(srcFile, destFile);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println("★" + driver.getTitle());
		if (driver != null) {
			System.out.println("ドライバーを終了します。");
			driver.quit();
		}
	}

}