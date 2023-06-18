package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IFramePage extends BasePage {

    @FindBy(css = "iframe#mce_0_ifr")
    private WebElement iFrame;

    @FindBy(css = "#tinymce")
    private WebElement body;

    public IFramePage (WebDriver driver)  {
        super(driver);
    }

    public void switchToiFrame(String text) {
        super.waitFor(ExpectedConditions.visibilityOf(this.iFrame));
        driver.switchTo().frame(iFrame);
        this.body.sendKeys(text);
    }

    public boolean isTextCorrect(String myText) {
        String currentText = this.body.getText();
        if (currentText.contains(myText)) {
            this.switchBack();
            return true;
        }
        return false;
    }

    public void switchBack() {
        driver.switchTo().defaultContent();
    }
}
