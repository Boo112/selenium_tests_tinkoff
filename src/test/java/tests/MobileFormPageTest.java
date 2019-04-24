package tests;

import application.BaseRunner;
import elements.Button;
import org.junit.Test;
import pages.GoogleMainPage;
import pages.GoogleResultPage;
import pages.TinkoffMobilePage;

import static org.junit.Assert.*;

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

    @Test
    public void testChangeRegion() throws InterruptedException {
        TinkoffMobilePage tinkoffMobilePage=app.tinkoffMobilePage;
        tinkoffMobilePage.openPage();
        tinkoffMobilePage.regionSelect("Москва и Московская");
        Thread.sleep(1000);
        assertEquals("Москва и Московская область", tinkoffMobilePage.getRegionNameOnThePage());
        tinkoffMobilePage.refreshPage();
        assertEquals("Москва и Московская область", tinkoffMobilePage.getRegionNameOnThePage());

        int totalPriceMoscow = tinkoffMobilePage.getTotalPrice();
        tinkoffMobilePage.regionSelect("Краснодарский кр.");
        int totalPriceKrasnodar = tinkoffMobilePage.getTotalPrice();
        assertNotEquals(totalPriceMoscow, totalPriceKrasnodar);

        tinkoffMobilePage.allOptionsOn();
        int fullPriceKrasnodar = tinkoffMobilePage.getTotalPrice();
        tinkoffMobilePage.regionSelect("Москва и Московская");
        tinkoffMobilePage.allOptionsOn();
        int fullPriceMoscow = tinkoffMobilePage.getTotalPrice();
        assertEquals(fullPriceMoscow, fullPriceKrasnodar);
    }

    @Test
    public void activeButton() throws InterruptedException {
        TinkoffMobilePage tinkoffMobilePage=app.tinkoffMobilePage;
        tinkoffMobilePage.openPage();
        tinkoffMobilePage.regionSelect("Москва и Московская");
        Thread.sleep(1000);
        tinkoffMobilePage.allOptionsOff();
        int price = tinkoffMobilePage.getTotalPrice();


        assertEquals(String.valueOf(price), "0");

        assertTrue(tinkoffMobilePage.isActiveButton());
    }


}
