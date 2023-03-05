package src;

import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}
