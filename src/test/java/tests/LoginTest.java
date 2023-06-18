package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.LoginPage;
import pageFactory.SecureAreaPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private SecureAreaPage secureAreaPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.loginPage = new LoginPage(driver);
        this.secureAreaPage = new SecureAreaPage(driver);
    }

    @Test(priority = 1)
    @Parameters({"userName", "password"})
    public void LoginSuccess(String userName, String password) {
        this.loginPage.fillUsernameInput(userName);
        this.loginPage.fillPasswordInput(password);
        this.loginPage.clickSubmitButton();
        Assert.assertTrue(this.secureAreaPage.isLoginMessageCorrect("You logged into a secure area!"));
    }

    @Test(priority = 2)
    @Parameters({"userName"})
    public void PasswordFailure(String userName) {
        this.loginPage.fillUsernameInput(userName);
        this.loginPage.fillPasswordInput("wrongpassword");
        this.loginPage.clickSubmitButton();
        Assert.assertTrue(this.loginPage.isErrorMessageCorrect("Your password is invalid!"));
    }

    @Test(priority = 3)
    @Parameters({"password"})
    public void UsernameFailure(String password) {
        this.loginPage.fillUsernameInput("wrongusername");
        this.loginPage.fillPasswordInput(password);
        this.loginPage.clickSubmitButton();
        Assert.assertTrue(this.loginPage.isErrorMessageCorrect("Your username is invalid!"));
    }

}

