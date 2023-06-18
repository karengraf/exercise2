package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageFactory.NotificationMessagePage;


public class NotificationMessageTest extends BaseTest {
    NotificationMessagePage notificationMessagePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.notificationMessagePage = new NotificationMessagePage (driver);
    }

    @Test(priority = 1)
    public void ClickHereAndAssertMessage() {
        SoftAssert softAssert = new SoftAssert();
        int timesToClick = 10;
        while (--timesToClick != 0) {
            this.notificationMessagePage.clickHere();
            softAssert.assertTrue(this.notificationMessagePage.isMessageCorrect("Action successful", "Action unsuccesful, please try again"));
        }
        softAssert.assertAll();
    }
}
