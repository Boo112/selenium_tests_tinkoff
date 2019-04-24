package pages;

import elements.CheckBox;
import elements.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TinkoffMobilePage extends Page {
    private static final String GOOGLE_PAGE_URL = "https://www.tinkoff.ru/mobile-operator/tariffs/";

    public TinkoffMobilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        goToUrl(GOOGLE_PAGE_URL);
    }

    public void regionSelect(String regionName) {
        WebElement region = driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']"));
        if (region.getText().contains("?")) {
            region = driver.findElement(By.xpath("//span[contains(@class, 'MvnoRegionConfirmation__optionRejection_1NrnL')]"));
        }
        region.click();

        getElementByTextElement(regionName).click();
        logger.info("Выбрали регион " + regionName);
    }

    public String getRegionNameOnThePage() {
        WebElement regionName = driver.findElement(By.xpath("//div[@data-qa-file='MvnoRegionConfirmation']"));
        return regionName.getText();
    }

    public int getTotalPrice() {
        return Integer.parseInt(getElementByTextElement("Общая цена").getText().replaceAll("\\D+", ""));
    }

    public void allOptionsOn() {
        Select internetOptions = new Select(driver, "internet");
        internetOptions.selectOption("Безлимитный интернет");

        Select callsOptions = new Select(driver, "calls");
        callsOptions.selectOption("Безлимитные минуты");

        CheckBox unLimitSMS = new CheckBox(driver, "2048");
        unLimitSMS.checkboxActivate();
        CheckBox modem = new CheckBox(driver, "2058");
        modem.checkboxActivate();

        logger.info("Включаем все пакеты и сервисы");
    }
}
