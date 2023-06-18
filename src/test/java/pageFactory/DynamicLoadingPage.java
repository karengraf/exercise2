package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends BasePage {

    @FindBy(xpath = "//button[text()='Start']")
    private WebElement startButton;

    @FindBy(css = "div#finish")
    private WebElement message;

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void clickStartButton() { this.startButton.click(); }

    public boolean checkForMessage(String expectedMessage) {
        super.waitFor(ExpectedConditions.textToBePresentInElement(this.message, expectedMessage));
        String currentMessage = this.message.getText();
        return currentMessage.equalsIgnoreCase(expectedMessage);
    }
}
