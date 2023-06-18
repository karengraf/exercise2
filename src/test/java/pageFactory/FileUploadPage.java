package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage {

    @FindBy(css = "#file-upload")
    private WebElement selectFile;

    @FindBy(css = "#file-submit")
    private WebElement submitFile;

    @FindBy(css = "#uploaded-files")
    private WebElement uploadedFile;

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String fileName) {
        //driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/data/"+fileName);
        this.selectFile.sendKeys(System.getProperty("user.dir")+"/src/test/resources/data/"+fileName);
        //driver.findElement(By.id("file-submit")).submit();
        this.submitFile.submit();
    }

    public boolean isFileUploaded(String expectedFile) {
        if (this.uploadedFile.getText().contains(expectedFile)) {
            return true;
        }
        return false;
    }
}



