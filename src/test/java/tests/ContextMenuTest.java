package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.ContextMenuPage;

public class ContextMenuTest extends BaseTest {
    private ContextMenuPage contextMenuPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.contextMenuPage = new ContextMenuPage(driver);
    }

    @Test(priority = 1)
    public void RightClickContextMenu() {
        this.contextMenuPage.rightClickOnElement();
        Assert.assertTrue(this.contextMenuPage.isAlertShown());
    }
}
