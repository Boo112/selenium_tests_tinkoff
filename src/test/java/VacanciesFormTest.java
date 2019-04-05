import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertEquals;

public class VacanciesFormTest extends BaseRunner {

    @Test
    public void testFieldsEmpty() {
        System.out.println("Стартуем тест проверка пустых полей формы...");
        driver.get(baseUrl);
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("socialLink0")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::span[1]")).click();

        assertEquals(ErrorMessages.FIELD_IS_EMPTY_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());
        assertEquals(ErrorMessages.FIELD_IS_EMPTY_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());
        assertEquals(ErrorMessages.FIELD_IS_EMPTY_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Город проживания'])[1]/following::div[3]")).getText());
        assertEquals(ErrorMessages.FIELD_IS_EMPTY_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")).getText());
        assertEquals(ErrorMessages.FIELD_IS_EMPTY_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText());
        assertEquals(ErrorMessages.FIELD_IS_EMPTY_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='загрузите резюме/портфолио'])[1]/following::div[1]")).getText());

    }

    @Test
    public void testFieldsInvalidName1() {
        System.out.println("Стартуем тест невалидных значений...1");
        driver.get(baseUrl);
        driver.findElement(By.name("name")).sendKeys(InvalidData.INVALID_FIO_ENG);
        driver.findElement(By.name("birthday")).sendKeys(InvalidData.INVALID_DATE_BIRTH);
        driver.findElement(By.name("email")).sendKeys(InvalidData.INVALID_EMAIL);
        driver.findElement(By.name("phone")).sendKeys(InvalidData.INVALID_TEL1);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::span[1]")).click();

        assertEquals(ErrorMessages.FIO_ICORRECT_LETTERS_ENG_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());
        assertEquals(ErrorMessages.DATE_BIRTH_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Дата рождения'])[1]/following::div[3]")).getText());
        assertEquals(ErrorMessages.EMAIL_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Электронная почта'])[1]/following::div[2]")).getText());
        assertEquals(ErrorMessages.PHONE_TEL_ERROR_1, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText());
    }

    @Test
    public void testFieldsInvalidName2() {
        System.out.println("Стартуем тест невалидных значений ...2");
        driver.get(baseUrl);

        driver.findElement(By.name("name")).sendKeys(InvalidData.INVALID_FIO_ONLY_NAME);
        driver.findElement(By.name("phone")).sendKeys(InvalidData.INVALID_TEL2);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::span[1]")).click();

        assertEquals(ErrorMessages.FIO_ICORRECT_LETTERS_SPACE_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());
        assertEquals(ErrorMessages.PHONE_TEL_ERROR_2, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Мобильный телефон'])[1]/following::div[2]")).getText());
    }

    @Test
    public void testFieldsInvalidName3() {
        System.out.println("Стартуем тест невалидных значений...3");
        driver.get(baseUrl);

        driver.findElement(By.name("name")).sendKeys(InvalidData.maxLimitName());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='условиями передачи информации'])[1]/following::span[1]")).click();

        assertEquals(ErrorMessages.FIO_ICORRECT_LETTERS_MAX_ERROR, driver
                .findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фамилия и имя'])[1]/following::div[2]")).getText());
    }
}
