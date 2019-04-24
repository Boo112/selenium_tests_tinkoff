package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleResultPage extends Page {

    public GoogleResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSearchResultsByLinkText(String linkText) {
        driver.findElement(By.partialLinkText(linkText)).click();
        logger.info("Кликаем по ссылке с текстом - "+linkText);
    }
}
