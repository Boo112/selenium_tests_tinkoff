package application;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.GoogleMainPage;
import pages.GoogleResultPage;
import pages.TinkoffMobilePage;
import pages.TinkoffVacanciesPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Application {
    Logger logger = LoggerFactory.getLogger(Application.class);
    private WebDriverWait wait;
    private WebDriver driver;
    public GoogleMainPage google;
    public GoogleResultPage googleResults;
    public TinkoffVacanciesPage tinkoffVacanciesPage;
    public TinkoffMobilePage tinkoffMobilePage;
    public final String browserName = "chrome";

    public Application() {
        driver = BrowsersFactory.valueOf(browserName).create();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //pages
        tinkoffVacanciesPage = new TinkoffVacanciesPage(driver);

        logger = LoggerFactory.getLogger(Application.class);
        logger.info("Браузер " + browserName + " стартует...");


    }

    public void quit() {
        driver.quit();
        driver = null;
    }

}
