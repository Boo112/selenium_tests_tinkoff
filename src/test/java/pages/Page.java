package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Page {
    Logger logger = LoggerFactory.getLogger(Page.class);

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean isLoadedByTitleContains(String substring) {
        wait.until(d -> d.getTitle().contains(substring));
        return true;
    }

    public void goToUrl(String url){
        driver.navigate().to(url);
        logger.info("Открыта вкладка "+url);
    }

    public void closeCurrentTab(){
        driver.close();
        logger.info("Закрыта активная вкладка");
    }

    public void switchToWindow(int tabNumber){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));

      //  wait.until(ExpectedConditions.titleContains(tabNumber));

       /* wait.until(d -> {
            boolean check = false;
            for (String title : driver.getWindowHandles()) {
                driver.switchTo().window(title);
                System.out.println(d.getTitle());
                check = d.getTitle().equals(tabNumber);
            }
            return check;
        });*/

        logger.info("Переключились на новую вкладку");
    }

    public String getTitlePage(){
        return driver.getTitle();
    }

    public String getUrlPage(){
        return driver.getCurrentUrl();
    }

    public WebElement getElementByTextElement(String textElement) {
        return driver.findElement(By.xpath(String.format("//*[text()[contains(.,'%s')]]", textElement)));
    }

    public void refreshPage(){
        driver.navigate().refresh();
        logger.info("Обновляем страницу...");
    }
}
