package pages;

import org.junit.Test;
import src.BaseTest;

import static org.junit.Assert.assertEquals;
import static pages.MainPage.PAGE_URL;

public class ReturnToMainPageAfterClickHome extends BaseTest  {
    @Test
    public void samokatLogoReturnToMainPageTest(){
        MainPage page = new MainPage(driver);
        page.open();
        page.createOrderTop();
        page.goToHomePage();

        assertEquals("Не перешли домой", PAGE_URL, page.getPageUrl());
    }
}