package pageFactory;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FloatingMenuPage extends BasePage {

    @FindBy(css = "div#menu")
    private WebElement menu;

    @FindBy(css = "#page-footer")
    private WebElement footer;

    public FloatingMenuPage(WebDriver driver)  {
        super(driver);
    }

    public void scrollDown() {
        new Actions(driver)
                .scrollToElement(this.footer)
                .perform();
    }

    public boolean isMenuVisible() {
        try {
            super.waitFor(ExpectedConditions.visibilityOf(this.menu));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
