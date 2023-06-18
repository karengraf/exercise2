package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownMenuPage extends BasePage {

    @FindBy(xpath = "//*[text()=\"Dropdown List\"]/following-sibling::*")
    private WebElement dropdownMenu;

    public DropdownMenuPage(WebDriver driver) {
        super(driver);
    }

    public void selectFromDropdownMenu(String option) {
        Select optionSelect = new Select(this.dropdownMenu);
        optionSelect.selectByVisibleText(option);
    }

    public boolean isOptionSelected(String option) {
        String currentOption = this.dropdownMenu.findElement(By.cssSelector("[selected='selected']")).getText();
        return currentOption.equals(option);
    }

    public boolean isOptionSelected2(String option) {
        Select optionSelect = new Select(this.dropdownMenu);
        String currentOption = optionSelect.getFirstSelectedOption().getText();
        return currentOption.equals(option);
    }

}

