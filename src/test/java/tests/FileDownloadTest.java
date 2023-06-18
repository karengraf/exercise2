package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageFactory.FileDownloadPage;

public class FileDownloadTest extends BaseTest {

    private FileDownloadPage fileDownloadPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.fileDownloadPage = new FileDownloadPage(driver);
    }

    @Test(priority = 1)
    public void DownloadFile() {
        this.fileDownloadPage.downloadFile();
        Assert.assertTrue(this.fileDownloadPage.isFileDownloaded("/Users/karengraf/Downloads", "some-file.txt"));
    }
}
