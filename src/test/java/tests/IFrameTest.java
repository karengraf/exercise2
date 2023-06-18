package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.IFramePage;

public class IFrameTest extends BaseTest{
    IFramePage iFramePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.iFramePage = new IFramePage(driver);
    }

    @Test(priority = 1)
    @Parameters({"text"})
    public void SwitchToiFrame(String text) {
        this.iFramePage.switchToiFrame(text);
        Assert.assertTrue(this.iFramePage.isTextCorrect(text));
    }
}
