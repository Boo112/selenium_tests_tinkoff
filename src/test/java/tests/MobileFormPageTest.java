package tests;

import application.BaseRunner;
import org.junit.Test;
import pages.GoogleMainPage;
import pages.GoogleResultPage;
import pages.TinkoffMobilePage;

import static org.junit.Assert.assertEquals;

public class MobileFormPageTest extends BaseRunner {

    @Test
    public void testPageTabs() throws InterruptedException {
        GoogleMainPage googleMainPage=app.google;
        googleMainPage.openPage();
        googleMainPage.searchByRequest("мобайл тинькофф");

        GoogleResultPage googleResult=app.googleResults;

        googleResult.clickSearchResultsByLinkText("мобайл тинькофф тарифы");

        //Без этого слипа не получется, уже делал через wait, по-разному, никак не выходит Ж(
        Thread.sleep(1000);

        TinkoffMobilePage tinkoffMobilePage=app.tinkoffMobilePage;
        tinkoffMobilePage.switchToWindow(1);
        assertEquals(tinkoffMobilePage.getTitlePage(),"Тарифы Тинькофф Мобайла");

        googleResult.switchToWindow(0);
        googleResult.closeCurrentTab();

        tinkoffMobilePage.switchToWindow(0);

        assertEquals(tinkoffMobilePage.getUrlPage(),"https://www.tinkoff.ru/mobile-operator/tariffs/");

    }
}
