package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageFactory.DynamicContentPage;

import java.util.List;

public class DynamicContentTest extends BaseTest {
    private DynamicContentPage dynamicContentPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.dynamicContentPage = new DynamicContentPage(driver);
    }

    @Test(priority = 1)
    public void CheckForContentChange() {
        SoftAssert softAssert = new SoftAssert();
        int timesToRefresh = 10;
        while (--timesToRefresh != 0) {
            List<String> oldContent = this.dynamicContentPage.getTextAsString();
            this.dynamicContentPage.refreshBrowser();
            List<String> newContent = this.dynamicContentPage.getTextAsString();
            softAssert.assertTrue(this.dynamicContentPage.hasContentChanged(oldContent, newContent));
        };
        softAssert.assertAll();
    }
}
