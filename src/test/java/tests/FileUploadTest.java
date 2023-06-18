package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.FileUploadPage;

public class FileUploadTest extends BaseTest {
    FileUploadPage fileUploadPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.fileUploadPage = new FileUploadPage(driver);
    }

    @Test(priority = 1)
    public void UploadFile() {
        this.fileUploadPage.uploadFile("notas.rtf");
        Assert.assertTrue(this.fileUploadPage.isFileUploaded("notas.rtf"));
    }
}
