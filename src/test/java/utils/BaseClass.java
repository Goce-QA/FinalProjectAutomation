package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

import java.time.Duration;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public SoftAssert assertt;
    public HomePage homePage;
    String url = "https://magento.softwaretestingboard.com";

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        assertt = new SoftAssert();
    }

    @AfterMethod
    public void exit() {
        driver.quit();
    }

    public void sleep (int mills) {
        try{
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
