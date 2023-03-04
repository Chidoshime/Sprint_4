package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static src.Dates.*;

public class CreateOrderPage {

    private final WebDriver driver;
    public CreateOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillPersonData(String name, String surname, String address, String subway, String phone){

        //Очищаем и заполняем имя
        driver.findElement(By.xpath(".//input[@placeholder='* Имя']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Имя']")).sendKeys(name);

        //Очищаем и заполняем фамилию
        driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Фамилия']")).sendKeys(surname);

        //Очищаем и заполняем адрес
        driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']")).sendKeys(address);

        //Очищаем и заполняем метро
        driver.findElement(By.xpath(".//input[@placeholder='* Станция метро']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Станция метро']")).sendKeys(subway);
        driver.findElement(By.xpath(".//div[contains(text(),'"+ subway +"')]")).click();

        //Очищаем и заполняем телефон
        driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']")).sendKeys(phone);
    }

    public void nextPage(){
        driver.findElement(By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM")).click();
    }

    public void fillRentDate(String rentDate){
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).sendKeys(rentDate);
        driver.findElement(By.cssSelector("div.react-datepicker__day--selected")).click();
    }

    public void fillRentDateByToday(){
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).clear();
        driver.findElement(By.xpath(".//input[@placeholder='* Когда привезти самокат']")).sendKeys(TODAY_DATE);
        driver.findElement(By.cssSelector("div.react-datepicker__day--selected")).click();
    }

    public void fillRentTerm(){
        driver.findElement(By.cssSelector("div.Dropdown-placeholder")).click();
        driver.findElement(By.xpath(".//div[text()='сутки']")).click();
    }

    public void fillRentTerm(String term){
        driver.findElement(By.cssSelector("div.Dropdown-placeholder")).click();
        driver.findElement(By.xpath(".//div[text()='"+ term +"']")).click();
    }

    public void setScooterType(String scooterType){
        if(scooterType != null){
            driver.findElement(By.id(scooterType)).click();
        }
    }

    public void setComment(String comment){
        if(comment != null){
            driver.findElement(By.xpath(".//input[@placeholder='Комментарий для курьера']")).clear();
            driver.findElement(By.xpath(".//input[@placeholder='Комментарий для курьера']")).sendKeys(comment);
        }
    }

    public void submitOrderPopUp(){
        driver.findElement(By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")).click();
    }

    public void submitOrderPopUpYes(){
        driver.findElement(By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']")).click();
    }

    public boolean checkSuccessfullyCreatedOrderPopup(){
        List<WebElement> finalPopup = driver.findElements(By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(),'Заказ оформлен')]"));
        return finalPopup.size() != 0;
    }
}
