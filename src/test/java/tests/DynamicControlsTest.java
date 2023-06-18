package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.DynamicControlsPage;


public class DynamicControlsTest extends BaseTest {
    private DynamicControlsPage dynamicControlsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.dynamicControlsPage = new DynamicControlsPage(driver);
    }

    @Test(priority = 1)
    public void CheckForCheckbox() {
        this.dynamicControlsPage.clickCheckboxButton();
        Assert.assertTrue(this.dynamicControlsPage.isCheckboxGone("It's gone!"));
        this.dynamicControlsPage.clickCheckboxButton();
        Assert.assertTrue(this.dynamicControlsPage.isCheckboxPresent("It's back!"));
    }

    @Test(priority = 2)
    public void CheckForInputBoxEnabled() {
        this.dynamicControlsPage.clickInputButton();
        Assert.assertTrue(this.dynamicControlsPage.isEnabledOrDisabled("It's enabled!"));
        this.dynamicControlsPage.clickInputButton();
        Assert.assertTrue(this.dynamicControlsPage.isEnabledOrDisabled("It's disabled!"));
    }
}
