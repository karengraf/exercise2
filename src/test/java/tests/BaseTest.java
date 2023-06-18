package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import util.ScreenshotUtil;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"appUrl"})
    public static void startTest(String appUrl) {
        driver = startDriver();
        if(driver!=null) {
            driver.get(appUrl);
        }
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        if(driver!=null) {
            driver.quit();
        }
    }

    @AfterMethod(alwaysRun = true)
    public static void addScreenshot(ITestResult result, Method testMethod) {

        String fileName = new StringBuilder(testMethod.getName()).append(new Date().getTime()).toString();
        ScreenshotUtil util = new ScreenshotUtil(driver);

        if (result.getStatus() == ITestResult.FAILURE) {

            String message = "";

            if (result.getThrowable() != null) {
                message = result.getThrowable().getMessage();
            }
            System.out.println(message);
            util.takeScreenshot (fileName);
        }
    }

    private static WebDriver startDriver() {
        try {
            System.setProperty("webdriver.http.factory", "jdk-http-client");
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(60));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return driver;
    }

    public void sleepFor (int milliSecs) {
        try {
            Thread.sleep(milliSecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
