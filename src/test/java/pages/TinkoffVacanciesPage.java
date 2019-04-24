package pages;

import elements.Button;
import elements.TextInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import testsHelper.ErrorMessages;

import static org.junit.Assert.assertEquals;

public class TinkoffVacanciesPage extends Page {

    private static final String VACANSIES_PAGE_URL = "https://www.tinkoff.ru/career/vacancies/";

    public TinkoffVacanciesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        goToUrl(VACANSIES_PAGE_URL);
    }

    public void clickOnEmptyFields() {
        TextInput name = new TextInput(driver, "//input[@name='name']");
        TextInput city = new TextInput(driver, "//input[@name='city']");
        TextInput birthday = new TextInput(driver, "//input[@name='birthday']");
        TextInput email = new TextInput(driver, "//input[@name='email']");
        TextInput phone = new TextInput(driver, "//input[@name='phone']");
        TextInput social = new TextInput(driver, "//input[@name='socialLink0']");
        Button button=new Button(driver,"//span[text()='Отправить']");
        name.click();
        city.click();
        birthday.click();
        email.click();
        phone.click();
        social.click();
        button.clickButton();
        logger.info("Кликаем по пустым полям в форме вакансии <<заполните анкету>>...");
    }

    public void checkErrorMessageUnderEmptyFields(String nameField){
        assertEquals(getErrorMessages("name"), ErrorMessages.FIELD_IS_EMPTY_ERROR);
        logger.info("Проверка сообщения об ошибке в поле "+nameField+" пройдена успешно");
    }

    private String getErrorMessages(String nameField){
        return driver.findElement(By.xpath("//input[@name='"+nameField+"']/ancestor::div[@data-qa-file='FormFieldWrapper']" +
                "/descendant::div[@data-qa-file='UIFormRowError']")).getText();
    }

}
