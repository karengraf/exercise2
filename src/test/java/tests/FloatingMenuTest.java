package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.FloatingMenuPage;

public class FloatingMenuTest extends BaseTest {
    FloatingMenuPage floatingMenuPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.floatingMenuPage = new FloatingMenuPage(driver);
    }

    @Test(priority = 1)
    public void IsMenuVisibleAfterScrolling() {
        this.floatingMenuPage.scrollDown();
        this.sleepFor(3000);
        Assert.assertTrue(this.floatingMenuPage.isMenuVisible());
    }
}
