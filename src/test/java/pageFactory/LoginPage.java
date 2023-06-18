package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(css = "[name=\"username\"]")
    private WebElement usernameInput;

    @FindBy(css = "[name=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "#flash")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) { super(driver); }

    public void fillUsernameInput(String userName) { this.usernameInput.sendKeys(userName); }

    public void fillPasswordInput(String password) { this.passwordInput.sendKeys(password);}

    public void clickSubmitButton() { this.submitButton.click(); }

    public boolean isErrorMessageCorrect(String expectedMessage) {
        String currentMessage = this.errorMessage.getText();
        return currentMessage.contains(expectedMessage);
    }
}
