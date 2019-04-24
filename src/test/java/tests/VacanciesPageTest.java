package tests;

import application.Application;
import application.BaseRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.TinkoffVacanciesPage;

import static org.junit.Assert.assertEquals;

public class VacanciesPageTest extends BaseRunner {

    @Test
    public void testFieldsEmpty() {
        TinkoffVacanciesPage tinkoffVacanciesPage= app.tinkoffVacanciesPage;
        tinkoffVacanciesPage.openPage();
        tinkoffVacanciesPage.clickOnEmptyFields();
        tinkoffVacanciesPage.checkErrorUnderEmptyFields("");

    }
}
