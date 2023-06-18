package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.MouseHoverPage;

public class MouseHoverTest extends BaseTest {
    MouseHoverPage mouseHoverPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.mouseHoverPage = new MouseHoverPage(driver);
    }

    @Test(priority = 1)
    public void HoverOverElements() {
        Assert.assertTrue(this.mouseHoverPage.hoverOnEachImage());
    }
}
