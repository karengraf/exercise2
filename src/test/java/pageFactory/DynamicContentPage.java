package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DynamicContentPage extends BasePage {

    @FindBy (css = "[class=\"large-10 columns\"]")
    private List<WebElement> texts;

    @FindBy (css = "[class=\"large-10 columns\"]")
    private WebElement text;


    public DynamicContentPage(WebDriver driver) {
        super(driver);
    }

    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    public List<String> getTextAsString() {
        List<String> textToReturn = new ArrayList<>();
        for (WebElement webElement : texts) {
            textToReturn.add(webElement.getText());
        }
        return textToReturn;
    }

    public boolean hasContentChanged(List<String> oldContent, List<String> newContent) {
        boolean isCorrect = true;
        for (int i = 0; i< oldContent.size(); i++) {
           if (oldContent.get(i).equals(newContent.get(i))) {
               isCorrect = false;
           };
        }
        return isCorrect;
    }
}
