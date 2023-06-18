package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.JavaScriptAlertsPage;


public class JavaScriptAlertsTest extends BaseTest{
    private JavaScriptAlertsPage javaScriptAlertsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.javaScriptAlertsPage = new JavaScriptAlertsPage(driver);
    }

    @Test(priority = 1)
    @Parameters({"text"})
    public void OpenAndCloseAlerts(String text) {
        this.javaScriptAlertsPage.openAndCloseAlert();
        Assert.assertTrue(this.javaScriptAlertsPage.isMessageCorrect("You successfuly clicked an alert"));
        this.javaScriptAlertsPage.openAndCloseConfirm();
        Assert.assertTrue(this.javaScriptAlertsPage.isMessageCorrect("You clicked: Ok"));
        this.javaScriptAlertsPage.openAndClosePrompt(text);
        Assert.assertTrue(this.javaScriptAlertsPage.isMessageCorrect("You entered: " + text));
    }
}
