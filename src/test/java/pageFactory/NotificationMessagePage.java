package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BasePage {
    @FindBy(css = "[href='/notification_message']")
    private WebElement clickHereButton;

    @FindBy(css = "#flash")
    private WebElement message;

    public NotificationMessagePage (WebDriver driver) { super(driver); }

    public void clickHere() {
        this.clickHereButton.click();
    }

    public boolean isMessageCorrect(String expectedMessage1, String expectedMessage2) {
        String currentMessage = this.message.getText();

        if (currentMessage.contains(expectedMessage1) || currentMessage.contains(expectedMessage2)) {
            System.out.println(currentMessage);
            return true;
        }
        return false;
    }
}
