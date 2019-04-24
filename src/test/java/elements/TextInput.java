package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextInput {
    private final WebDriver driver;
    private final String elementLocator;

    public TextInput(WebDriver driver, String elementLocator) {
        this.driver = driver;
        this.elementLocator = elementLocator;
    }

    public void setText(String text) {
        driver.findElement(By.xpath(elementLocator)).sendKeys(text);
    }

    public void getText() {
        driver.findElement(By.xpath(elementLocator)).getText();
    }

    public void submit() {
        driver.findElement(By.xpath(elementLocator)).submit();
    }

    public void click() {
        driver.findElement(By.xpath(elementLocator)).click();
    }
}
