package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.DynamicLoadingPage;

public class DynamicLoadingTest extends BaseTest {

    private DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @Test(priority = 1)
    public void LoadPageContent() {
        this.dynamicLoadingPage.clickStartButton();
        Assert.assertTrue(this.dynamicLoadingPage.checkForMessage("Hello World!"));
    }
}
