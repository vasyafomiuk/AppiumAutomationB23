package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        //we can specify capability name with MobileCapabilityType class
        caps.setCapability("deviceName", "Pixel 3");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10");
        caps.setCapability("automationName", "UiAutomator2");
        //app under test
        caps.setCapability("app", "https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        // WebDriver driver = new ChromeDriver();
        //Chrome = ChromeDriver
        //Android = AndroidDriver
        //IOS = IOSDriver'
        //Selenium Grid = RemoteWebDriver
        //WebElement -> MobileElement -> AndroidElement/IOSElement
        //WebDriver -> RemoteWebDriver -> ChromeDriver
        //                                AppiumDriver -> AndroidDriver/IOSDriver
        driver = new AndroidDriver<>(url, caps);

        // MobileBy is a child of By class
        //AccessibilityId new locator strategy. Available only in mobile apps
        //find element by id and click it
        driver.findElement(By.xpath("//*[@text='1']")).click();
        driver.findElement(By.xpath("//*[@text='5']")).click();
        driver.findElement(MobileBy.AccessibilityId("plus")).click();
        driver.findElement(By.xpath("//*[@text='6']")).click();
        Thread.sleep(3000);
        driver.findElement(MobileBy.AccessibilityId("equals")).click();
        Thread.sleep(3000);

        String expected = "21";
        By resultBy = By.id("com.google.android.calculator:id/result_final");
        String actualResult = driver.findElement(resultBy).getText();

        Assertions.assertEquals(expected, actualResult, "result is not correct");
        driver.closeApp();
    }
}
