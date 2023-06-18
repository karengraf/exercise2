package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MouseHoverPage extends BasePage {

    @FindBy(css = "div.figure")
    private List<WebElement> images;

    public MouseHoverPage(WebDriver driver) { super(driver); }

    public boolean hoverOnEachImage() {
        boolean isOkay = true;
        for (int i = 0; i< images.size(); i++) {
            WebElement image = this.images.get(i);
            new Actions(driver)
                    .moveToElement(image)
                    .perform();
            String caption = image.findElement(By.cssSelector("div.figcaption")).getText();
            if (caption.isEmpty()) {
                isOkay = false;
            }
        }
        return isOkay;
    }
}
