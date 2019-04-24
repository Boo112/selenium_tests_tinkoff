package pages;

import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class GoogleMainPage extends Page {
    private static final String GOOGLE_PAGE_URL = "https://www.google.ru/";

    public GoogleMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        goToUrl(GOOGLE_PAGE_URL);
    }

    public void searchByRequest(String request) {
        TextInput inputString = new TextInput(driver, "//input[@name='q']");
        inputString.setText(request);
        inputString.submit();

        //ожидание, игнорирующее StaleElementReferenceException
      /*  wait
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Что-то пошло не так...")
                .pollingEvery(Duration.ofMillis(500))
                .until(d -> {
                    //список поисковой выдачи
                    By listItems = By.xpath("//ul[@role='listbox']/li[@role='presentation' and .//*[@role='option']]");
                    List<WebElement> elements = driver.findElements(listItems);
                    for (WebElement el : elements) {
                        System.out.println(el.getText());
                        //из списка вариантов дожиаемся появления нужного, кликаем
                        if (el.getText().equals(request.toLowerCase())) el.click();
                        break;
                    }
                    //Ожидание появления заголовка
                    return d.getTitle().contains(request.toLowerCase() + " - Поиск в Google");
                });
                */

    }


}
