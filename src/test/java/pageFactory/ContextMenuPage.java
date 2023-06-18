package pageFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContextMenuPage extends BasePage {

    @FindBy(id = "hot-spot")
    private WebElement hotSpot;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void rightClickOnElement() {
        new Actions(driver)
                .contextClick(this.hotSpot)
                .perform();
    }

    public boolean isAlertShown () {
            super.waitFor(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String currentText = alert.getText();
            boolean isCorrect = false;
            String expectedText = "You selected a context menu";
            isCorrect = currentText.equalsIgnoreCase(expectedText);
            this.closeAlert();
            return isCorrect;
        }

    public void closeAlert() {
        super.waitFor(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}

