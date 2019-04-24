package tests;

import application.BaseRunner;
import org.junit.Test;
import pages.TinkoffVacanciesPage;

public class VacanciesPageTest extends BaseRunner {

    @Test
    public void testFieldsEmpty() {
        TinkoffVacanciesPage tinkoffVacanciesPage= app.tinkoffVacanciesPage;
        tinkoffVacanciesPage.openPage();
        tinkoffVacanciesPage.clickOnEmptyFields();

        tinkoffVacanciesPage.checkErrorMessageUnderEmptyFields("name");
        tinkoffVacanciesPage.checkErrorMessageUnderEmptyFields("city");
        tinkoffVacanciesPage.checkErrorMessageUnderEmptyFields("birthday");
        tinkoffVacanciesPage.checkErrorMessageUnderEmptyFields("email");
        tinkoffVacanciesPage.checkErrorMessageUnderEmptyFields("phone");
        tinkoffVacanciesPage.checkErrorMessageUnderEmptyFields("socialLink0");
    }
}
