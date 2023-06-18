package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxPage extends BasePage {
    @FindBy(css = "[type=\"checkbox\"]")
    private List<WebElement> checkBoxes;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void checkAndUncheckBoxes(boolean check, int index) {
        for (int i = 0; i < checkBoxes.size(); i++)
            if (check) {
                if (!this.checkBoxes.get(index).isSelected()) {
                    this.checkBoxes.get(index).click();
                }
            } else {
                if (this.checkBoxes.get(index).isSelected()) {
                    this.checkBoxes.get(index).click();
                }
            }
    }

    public boolean isCheckBoxCorrect(int index) {
        if (this.checkBoxes.get(index).isSelected()) {
            return true;
        }
        return false;
    }
}


