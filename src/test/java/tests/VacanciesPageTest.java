package tests;

import application.BaseRunner;
import org.junit.Test;
import pages.TinkoffVacanciesPage;
import testsHelper.ErrorMessages;

public class VacanciesPageTest extends BaseRunner {

    @Test
    public void testFieldsEmpty() {
        TinkoffVacanciesPage tinkoffVacanciesPage = app.tinkoffVacanciesPage;
        tinkoffVacanciesPage.openPage();
        tinkoffVacanciesPage.clickOnEmptyFields();

        tinkoffVacanciesPage.checkErrorMessageUnderFields("name", ErrorMessages.FIELD_IS_EMPTY_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("city", ErrorMessages.FIELD_IS_EMPTY_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("birthday", ErrorMessages.FIELD_IS_EMPTY_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("email", ErrorMessages.FIELD_IS_EMPTY_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("phone", ErrorMessages.FIELD_IS_EMPTY_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("socialLink0", ErrorMessages.FIELD_IS_EMPTY_ERROR);
    }

    @Test
    public void testFieldsInvalidName1() {
        TinkoffVacanciesPage tinkoffVacanciesPage = app.tinkoffVacanciesPage;
        tinkoffVacanciesPage.openPage();
        tinkoffVacanciesPage.inputIncorrectTextInFields1();

        tinkoffVacanciesPage.checkErrorMessageUnderFields("name",
                ErrorMessages.FIO_ICORRECT_LETTERS_ENG_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("birthday",
                ErrorMessages.DATE_BIRTH_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("email",
                ErrorMessages.EMAIL_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("phone",
                ErrorMessages.PHONE_TEL_ERROR_1);
    }

    @Test
    public void testFieldsInvalidName2() {
        TinkoffVacanciesPage tinkoffVacanciesPage = app.tinkoffVacanciesPage;
        tinkoffVacanciesPage.openPage();
        tinkoffVacanciesPage.inputIncorrectTextInFields2();

        tinkoffVacanciesPage.checkErrorMessageUnderFields("name",
                ErrorMessages.FIO_ICORRECT_LETTERS_SPACE_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("phone",
                ErrorMessages.PHONE_TEL_ERROR_2);
    }

    @Test
    public void testFieldsInvalidName3() {
        TinkoffVacanciesPage tinkoffVacanciesPage = app.tinkoffVacanciesPage;
        tinkoffVacanciesPage.openPage();
        tinkoffVacanciesPage.inputIncorrectTextInFields3();

        tinkoffVacanciesPage.checkErrorMessageUnderFields("name",
                ErrorMessages.FIO_ICORRECT_LETTERS_MAX_ERROR);
    }
}
