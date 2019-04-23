import elements.Button;
import elements.CheckBox;
import elements.Select;
import elements.TextInput;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MobileFormTest extends BaseRunner {

    @Test
    public void testPage() throws InterruptedException {
        driver.get("https://www.google.ru/");

        TextInput inputString = new TextInput(driver, "//input[@name='q']");
        inputString.setText("мобайл тинькофф");
        inputString.submit();

        driver.findElement(By.partialLinkText("Тарифы Тинькофф Мобайла")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
       // new WebDriverWait(driver, 4).until(
        //        webDriver -> (driver.findElement(By.xpath("//p[contains(text(),'Тарифы Тинькофф Мобайла')]")).isDisplayed()));
        // new WebDriverWait(driver, 10).until(
        //         webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(1000); // по-другому не работает :(
        assertEquals("Тарифы Тинькофф Мобайла", driver.getTitle());

        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
        assertEquals("https://www.tinkoff.ru/mobile-operator/tariffs/", driver.getCurrentUrl());
    }

    @Test
    public void testChangeRegion() throws InterruptedException {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");

        regionSelect("Москва и Московская");
        Thread.sleep(1000);//по-другому не работает
        assertEquals("Москва и Московская область", getRegionNameOnThePage());
        driver.navigate().refresh();
        assertEquals("Москва и Московская область", getRegionNameOnThePage());

        int totalPriceMoscow = getTotalPrice();
        regionSelect("Краснодарский кр.");
        int totalPriceKrasnodar = getTotalPrice();
        assertNotEquals(totalPriceMoscow, totalPriceKrasnodar);

        allOptionsOn();
        int fullPriceKrasnodar = getTotalPrice();
        regionSelect("Москва и Московская");
        allOptionsOn();
        int fullPriceMoscow = getTotalPrice();
        assertEquals(fullPriceMoscow, fullPriceKrasnodar);
    }

    @Test
    public void activeButton() {
        driver.get("https://www.tinkoff.ru/mobile-operator/tariffs/");
        regionSelect("Москва и Московская");
        allOptionsOff();
        int price = getTotalPrice();
        assertEquals(String.valueOf(price), "0");
        Button button = new Button(driver);
        assertEquals(button.isActiveButton(), true);
    }

    @Test
    public void downloadRandomDocument() {
        driver.get("https://www.tinkoff.ru/mobile-operator/documents/");
        // Thread.sleep(1000);//по-другому не работает

    }


    private void regionSelect(String regionName) {
        WebElement region = driver.findElement(By.xpath("//div[@class='MvnoRegionConfirmation__title_DOqnW']"));
        if (region.getText().contains("?")) {
            region = driver.findElement(By.xpath("//span[contains(@class, 'MvnoRegionConfirmation__optionRejection_1NrnL')]"));
        }
        region.click();

        getElementByTextElement(regionName).click();
    }

    private String getRegionNameOnThePage() {
        WebElement regionName = driver.findElement(By.xpath("//div[@data-qa-file='MvnoRegionConfirmation']"));
        return regionName.getText();
    }

    private WebElement getElementByTextElement(String textElement) {
        return driver.findElement(By.xpath(String.format("//*[text()[contains(.,'%s')]]", textElement)));
    }

    private int getTotalPrice() {
        return Integer.parseInt(getElementByTextElement("Общая цена").getText().replaceAll("\\D+", ""));
    }


    private void allOptionsOn() {

        Select internetOptions = new Select(driver, "internet");
        internetOptions.selectOption("Безлимитный интернет");

        Select callsOptions = new Select(driver, "calls");
        callsOptions.selectOption("Безлимитные минуты");

        CheckBox unLimitSMS = new CheckBox(driver, "2048");
        unLimitSMS.checkboxActivate();
        CheckBox modem = new CheckBox(driver, "2058");
        modem.checkboxActivate();

    }

    private void allOptionsOff() {

        Select internetOptions = new Select(driver, "internet");
        internetOptions.selectOption("0 ГБ");

        Select callsOptions = new Select(driver, "calls");
        callsOptions.selectOption("0 минут");

        CheckBox unLimitSMS = new CheckBox(driver, "2048");
        unLimitSMS.checkboxActivate();
        CheckBox messengers = new CheckBox(driver, "2050");
        messengers.checkboxActivate();
        CheckBox music = new CheckBox(driver, "2046");
        music.checkboxActivate();
        CheckBox video = new CheckBox(driver, "2047");
        video.checkboxActivate();
        CheckBox social = new CheckBox(driver, "2053");
        social.checkboxActivate();

    }
}
