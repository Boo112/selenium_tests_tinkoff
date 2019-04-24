package pages;

import elements.Button;
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
        logger.info("Открываем url - " + GOOGLE_PAGE_URL);
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
        unLimitSMS.checkboxActivate(true);
        CheckBox modem = new CheckBox(driver, "2058");
        modem.checkboxActivate(true);

        logger.info("Включаем все пакеты и сервисы");
    }

    public void allOptionsOff() {

        Select internetOptions = new Select(driver, "internet");
        internetOptions.selectOption("0 ГБ");

        Select callsOptions = new Select(driver, "calls");
        callsOptions.selectOption("0 минут");

        CheckBox unLimitSMS = new CheckBox(driver, "2048");
        unLimitSMS.checkboxActivate(false);
        CheckBox messengers = new CheckBox(driver, "2050");
        messengers.checkboxActivate(false);
        CheckBox music = new CheckBox(driver, "2046");
        music.checkboxActivate(false);
        CheckBox video = new CheckBox(driver, "2047");
        video.checkboxActivate(false);
        CheckBox social = new CheckBox(driver, "2053");
        social.checkboxActivate(false);

        logger.info("Отключаем все пакеты и сервисы");
    }

    public boolean isActiveButton() {
        Button button = new Button(driver, "//div[contains(text(),'Заказать сим-карту')]");
        logger.info("Проверяем доступна ли кнопка Отправить");
        return button.isActiveButton();
    }
}
