package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    private final WebDriver driver;
    private final String elementLocator;

    public Button(WebDriver driver,String elementLocator) {
        this.driver = driver;
       // this.elementLocator = "//div[contains(text(),'Заказать сим-карту')]";
        this.elementLocator=elementLocator;
    }

    public boolean isActiveButton() {
        return driver.findElement(By.xpath(elementLocator)).isEnabled();
    }

    public void clickButton() {
        driver.findElement(By.xpath(elementLocator)).click();
    }
}
