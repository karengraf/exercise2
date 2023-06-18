package tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.CheckboxPage;


public class CheckboxTest extends BaseTest {
    private CheckboxPage checkboxPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.checkboxPage = new CheckboxPage(driver);
    }

    @Test(priority = 1)
    public void CheckAndUncheckBoxes() {
        this.checkboxPage.checkAndUncheckBoxes(true, 0);
        Assert.assertTrue(this.checkboxPage.isCheckBoxCorrect(0));
        this.checkboxPage.checkAndUncheckBoxes(false, 1);
        Assert.assertFalse(this.checkboxPage.isCheckBoxCorrect(1));
    }
}
