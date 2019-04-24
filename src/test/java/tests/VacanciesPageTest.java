package tests;

import application.BaseRunner;
import org.junit.Test;
import pages.TinkoffVacanciesPage;
import testsHelper.ErrorMessages;

public class VacanciesPageTest extends BaseRunner {

    @Test
    public void testFieldsEmpty() {
        TinkoffVacanciesPage tinkoffVacanciesPage= app.tinkoffVacanciesPage;
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
    public void testFieldsInvalidName() {
        TinkoffVacanciesPage tinkoffVacanciesPage= app.tinkoffVacanciesPage;
        tinkoffVacanciesPage.openPage();
        tinkoffVacanciesPage.inputIncorrectTextInFields();

        tinkoffVacanciesPage.checkErrorMessageUnderFields("name",
                ErrorMessages.FIO_ICORRECT_LETTERS_ENG_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("birthday",
                ErrorMessages.DATE_BIRTH_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("email",
                ErrorMessages.EMAIL_ERROR);
        tinkoffVacanciesPage.checkErrorMessageUnderFields("phone",
                ErrorMessages.PHONE_TEL_ERROR_1);

    }
}
