package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static pages.MainPage.PAGE_URL;

public class ReturnToMainPageAfterClickHome {
    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void samokatLogoReturnToMainPageTest(){
        MainPage page = new MainPage(driver);
        page.open();
        page.createOrderTop();
        page.goToHomePage();

        assertEquals("Не перешли домой", PAGE_URL, page.getPageUrl());
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}