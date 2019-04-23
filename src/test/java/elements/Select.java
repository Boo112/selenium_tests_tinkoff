package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Select {
    private final WebDriver driver;
    private final String elementLocator;

    public Select(WebDriver driver, String options) {
        this.driver = driver;
        this.elementLocator = "//select[@name='" + options + "']/ancestor::div[@class='ui-form__row ui-form__row_select']";
    }

    public void selectOption(String nameOptions) {
        driver.findElement(By.xpath(elementLocator)).click();
        driver.findElement(By.xpath(elementLocator +
                "//span[@class='ui-dropdown-field-list__item-text'][contains(text(),'" + nameOptions + "')]")).click();
    }
}
