package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.DropdownMenuPage;

public class DropdownMenuTest extends BaseTest {
    private DropdownMenuPage dropdownMenuPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.dropdownMenuPage = new DropdownMenuPage(driver);
    }

    @Test(priority = 1)
    public void SelectFromDropdownMenu() {
        this.dropdownMenuPage.selectFromDropdownMenu("Option 1");
        Assert.assertTrue(this.dropdownMenuPage.isOptionSelected("Option 1"));
        this.dropdownMenuPage.selectFromDropdownMenu("Option 2");
        Assert.assertTrue(this.dropdownMenuPage.isOptionSelected("Option 2"));
    }
}
