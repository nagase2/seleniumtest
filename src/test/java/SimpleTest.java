
import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

import junit.framework.TestCase;

public class SimpleTest extends TestCase {

    public interface WebDriverFactory {

        public WebDriver create();

    }

    public static Iterable<WebDriverFactory> getDriverFactories() {
        ArrayList<WebDriverFactory> factories = new ArrayList<WebDriverFactory>();
        factories.add(new WebDriverFactory() {
            @Override
            public WebDriver create() {
                return new FirefoxDriver();
            }
        });
        factories.add(new WebDriverFactory() {
            @Override
            public WebDriver create() {
                return new ChromeDriver();
            }
        });
        return factories;
    }

    // おためし：コードに直接書くべきではない・・・
    private static final String url = "https://prezi.com";
    private static final String id = "hogehoge";
    private static final String password = "fugafuga";

    @Test
    public void testXXX() throws Exception {
        for (WebDriverFactory factory : getDriverFactories()) {
            WebDriver driver = factory.create();
            try {
            	System.out.println("test start");
                driver.get(url);
                org.openqa.selenium.support.ui.Wait<WebDriver> wait = new WebDriverWait(driver, 30);

                // Login page
                WebElement button = wait.until(ExpectedConditions
                        .elementToBeClickable(By.className("btn-primary")));
                assertTrue(driver.getTitle().contains("YYY Dashboard"));
                assertTrue(driver.getTitle().contains("Login")
                        || driver.getTitle().contains("ログイン"));
                driver.findElement(By.id("id_username")).sendKeys(id);
                driver.findElement(By.id("id_password")).sendKeys(password);
                button.submit();

                // Top page
//                WebElement linkElement = wait
//                        .until(ExpectedConditions.elementToBeClickable(By
//                                .xpath("//a[@href='/path/to/xxx']")));
//                linkElement.sendKeys(Keys.ENTER);

                // XXX page
//                wait.until(ExpectedConditions.visibilityOfElementLocated(By
//                        .id("xxx")));
                System.out.println("CCC");
                assertTrue(driver.getTitle().contains("YYY Dashboard"));
                assertTrue(driver.getTitle().contains("XXX"));

                FileUtils.copyFile(((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE), new File(driver
                        .getClass().getName() + "-xxx.png"));
            } finally {
                driver.quit();
            }
        }
    }

}