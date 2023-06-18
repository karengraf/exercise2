package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.NewTabPage;
import pageFactory.OpenInNewTabPage;

public class OpenInNewTabTest extends BaseTest {
    OpenInNewTabPage openInNewTabPage;
    NewTabPage newTabPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.openInNewTabPage = new OpenInNewTabPage(driver);
        this.newTabPage = new NewTabPage(driver);
    }

    @Test(priority = 1)
    public void OpenInNewTab() {
        this.openInNewTabPage.openInNewTab();
        Assert.assertTrue(this.newTabPage.isTitleCorrect("New Window"));
    }
}
