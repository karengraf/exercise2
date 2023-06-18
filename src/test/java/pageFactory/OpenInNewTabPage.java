package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class OpenInNewTabPage extends BasePage{
    @FindBy(css = "[href='/windows/new']")
    private WebElement link;

    public OpenInNewTabPage(WebDriver driver) { super(driver); }

    public void openInNewTab() {
        this.link.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //driver.close();
        //driver.switchTo().window(tabs.get(0));
    }

}
