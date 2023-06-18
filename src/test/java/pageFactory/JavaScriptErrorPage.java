package pageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptErrorPage extends BasePage{

    private JavascriptExecutor js;
    public JavaScriptErrorPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public String executeError() {
        return (String) js.executeScript("try {loadError()} catch (e) {return (e.toString())}");
    }
}
