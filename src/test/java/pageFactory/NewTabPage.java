package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTabPage extends BasePage{
    @FindBy(css = ".example")
    private WebElement title;

    public NewTabPage(WebDriver driver) { super(driver); }

    public boolean isTitleCorrect(String expectedTitle) {
        String currentTitle = this.title.getText();
        if(currentTitle.contains(expectedTitle)) {
            return true;
        }
        return false;
    }
}
