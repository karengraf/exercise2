package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicControlsPage extends BasePage {

    @FindBy(css = "[onclick=\"swapCheckbox()\"]")
    private WebElement checkboxButton;

    @FindBy(css = "[onclick=\"swapInput()\"]")
    private WebElement inputButton;

    @FindBy(css = "p#message")
    private WebElement message;

    @FindBy(css = "input[type=checkbox]")
    private WebElement checkbox;

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckboxButton() {
        this.checkboxButton.click();
    }

    public void clickInputButton() {
        this.inputButton.click();
    }

    /*public boolean isCheckboxGone() {
        super.waitFor(ExpectedConditions.invisibilityOf(this.checkbox));
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            this.checkbox.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
    }*/

    public boolean isCheckboxGone(String expectedMessage) {
        try {
            super.waitFor(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), expectedMessage));
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
            this.checkbox.isDisplayed();
            return false;
        } catch (NoSuchElementException exception) {
            return true;
        }
        finally {
            this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
    }

    public boolean isCheckboxPresent(String expectedMessage) {
        super.waitFor(ExpectedConditions.textToBePresentInElement(this.message, expectedMessage));
        String currentMessage = this.message.getText();
        return currentMessage.equalsIgnoreCase(expectedMessage);
    }

    public boolean isEnabledOrDisabled(String expectedMessage) {
        super.waitFor(ExpectedConditions.textToBePresentInElement(this.message, expectedMessage));
        String currentMessage = this.message.getText();
        return currentMessage.equalsIgnoreCase(expectedMessage);
    }
}
