package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    // Локатор для верхней кнопки "Заказать"
    public static final String TOP_ORDER_BUTTON = ".//button[@class='Button_Button__ra12g']";
    // Локатор для нижней кнопки "Заказать"
    public static final String BOTTOM_ORDER_BUTTON = ".//div[@class='Home_FinishButton__1_cWm']/button";

    private final WebDriver driver;


    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    public void open(){
        driver.get(PAGE_URL);
    }

    public void createOrderTop() {
        driver.findElement(By.xpath(TOP_ORDER_BUTTON)).click();
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement getFAQHeader(String question){
        return driver.findElement(By.id(question));
    }

    public WebElement getFAQAnswer(String question){
        return driver.findElement(By.xpath(".//div[@id='"+question+"']/../following::div[1]"));
    }
    public void openFAQ(String question){
        driver.findElement(By.id(question)).click();
    }
    public String getFAQAnswerText(String question){
        return driver.findElement(By.xpath(".//div[@id='"+question+"']/../following::div[1]")).getText();
    }
    public void goToHomePage(){
        driver.findElement(By.xpath(".//img[@alt='Scooter']")).click();
    }
    public String getPageUrl(){
        return driver.getCurrentUrl();
    }
}