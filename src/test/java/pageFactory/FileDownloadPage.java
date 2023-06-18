package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class FileDownloadPage extends BasePage{

    @FindBy(css = "[href='download/some-file.txt']")
    private WebElement file;

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    public void downloadFile(){
        this.file.click();
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File file = new File(downloadPath);
            if (file.getName().equals(fileName)) {
                file.delete();
                return true;
            }
            return false;
    }




}
