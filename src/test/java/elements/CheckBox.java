package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private final WebDriver driver;
    private final String elementLocator;
    // private static final String ANCESTOR = "/ancestor::div[@class='Checkbox__inputOuter_5tJV0']";
    // private static final String ANCESTOR = "/ancestor::div[@class='CheckboxWithDescription__checkbox_2E0r_']";
    private static final String ANCESTOR = "/ancestor::div[@data-qa-file='CheckboxWithDescription']";

    public CheckBox(WebDriver driver, String nameCheckBox) {
        this.driver = driver;
        this.elementLocator = "//input[@id='" + nameCheckBox + "']";
    }

    public void checkboxActivate() {
        if (getStatusCheckbox() == false) {
            driver.findElement(By.xpath(elementLocator + ANCESTOR)).click();
        }
    }

    boolean getStatusCheckbox() {
        System.out.println(driver.findElement(By.xpath(elementLocator)).isSelected()+" "+elementLocator);
        return driver.findElement(By.xpath(elementLocator + ANCESTOR)).isSelected();
    }

    public String getCheckBoxText() {
        return driver.findElement(By.xpath(elementLocator + ANCESTOR)).getText();
    }
}