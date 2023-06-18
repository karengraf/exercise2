package pageFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JavaScriptAlertsPage extends BasePage{

    @FindBy(css = "[onclick='jsAlert()']")
    private WebElement jsAlert;

    @FindBy(css = "[onclick='jsConfirm()']")
    private WebElement jsConfirm;

    @FindBy(css = "[onclick='jsPrompt()']")
    private WebElement jsPrompt;

    @FindBy(css = "#result")
    private WebElement message;

    public JavaScriptAlertsPage(WebDriver driver) { super(driver); }

    public void openAndCloseAlert() {
        this.jsAlert.click();
        this.closeAlert();
    }

    public void openAndCloseConfirm() {
        this.jsConfirm.click();
        this.closeAlert();
    }

    public void openAndClosePrompt(String text) {
        this.jsPrompt.click();
        super.waitFor(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public boolean isMessageCorrect(String expectedMessage) {
        String currentMessage = this.message.getText();
        if (currentMessage.contains(expectedMessage)) {
            return true;
        }
        return false;
    }

    public void closeAlert() {
        super.waitFor(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
