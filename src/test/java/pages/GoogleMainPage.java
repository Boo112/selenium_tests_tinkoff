package pages;

import elements.TextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage extends Page {
    private static final String GOOGLE_PAGE_URL = "https://www.google.ru/";

    public GoogleMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        goToUrl(GOOGLE_PAGE_URL);
        logger.info("Открываем url - " + GOOGLE_PAGE_URL);
    }

    public void searchByRequest(String request) {
        TextInput inputString = new TextInput(driver, "//input[@name='q']");
        inputString.setText(request);
        inputString.submit();
        logger.info("Поиск google запроса - " + request);
    }
}
