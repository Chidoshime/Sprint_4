package pages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import static org.junit.Assert.assertEquals;
import static src.MainPageFAQ.*;

@RunWith(Parameterized.class)
public class MainPageTestFAQ {

    private WebDriver driver;

    private final String question;
    private final String questionAnswer;

    public MainPageTestFAQ(String question, String questionAnswer){
        this.question = question;
        this.questionAnswer = questionAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {HOW_MUCH_IT_COST, HOW_MUCH_IT_COST_ANSWER},
                {MULTIPLE_SCOOTERS, MULTIPLE_SCOOTERS_ANSWER},
                {HOW_RENT_TIME_CALCULATED, HOW_RENT_TIME_CALCULATED_ANSWER},
                {ORDER_ON_TODAY, ORDER_ON_TODAY_ANSWER},
                {PROLONGATION_SHORTING, PROLONGATION_SHORTING_ANSWER},
                {IS_CHARGER_INCLUDED, IS_CHARGER_INCLUDED_ANSWER},
                {CANCEL_ORDER, CANCEL_ORDER_ANSWER},
                {DELIVERY_OUT_MKAD, DELIVERY_OUT_MKAD_ANSWER},
        };
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void checkFrequentlyAskedQuestionsText(){

        MainPage page = new MainPage(driver);

        page.open();
        page.scrollToElement(page.getFAQHeader(question));
        page.openFAQ(question);
        page.waitForElement(page.getFAQAnswer(question));

        assertEquals("Текст ответа не совпадает",questionAnswer, page.getFAQAnswerText(question));

    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}