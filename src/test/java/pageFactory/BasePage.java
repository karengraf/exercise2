package pageFactory;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected final WebDriver driver;
    protected final FluentWait<WebDriver> wait;

    public BasePage(WebDriver driver){
        this.driver  = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);
        PageFactory.initElements(this.driver,this);
    }

    protected void waitFor(ExpectedCondition<?> waitCondition) {
        wait.until(waitCondition);
    }

    protected void explicitWaitForVisibilityElement(WebElement element) {
        waitFor(ExpectedConditions.visibilityOf(element));
    }

}
