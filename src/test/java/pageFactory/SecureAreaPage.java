package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.w3c.dom.ls.LSOutput;

public class SecureAreaPage extends BasePage {

    @FindBy(css = ".flash.success")
    private WebElement loginMessage;

    public SecureAreaPage(WebDriver driver) { super(driver); }

    public boolean isLoginMessageCorrect (String expectedMessage) {
        String currentMessage = this.loginMessage.getText();
        return currentMessage.contains(expectedMessage);
    }

}
