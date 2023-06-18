package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.JavaScriptAlertsPage;
import pageFactory.JavaScriptErrorPage;

public class JavaScriptErrorTest extends BaseTest {

    JavaScriptErrorPage javaScriptErrorPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.javaScriptErrorPage = new JavaScriptErrorPage(driver);
    }

    @Test(priority = 1)
    public void AssertJSError() {
        Assert.assertEquals(this.javaScriptErrorPage.executeError(),"TypeError: Cannot read properties of undefined (reading 'xyz')");
    }
}
