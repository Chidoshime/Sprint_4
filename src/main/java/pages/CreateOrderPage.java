package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static src.Dates.TODAY_DATE;

public class CreateOrderPage {

    private final WebDriver driver;

    private final By nameField =By.xpath(".//input[@placeholder='* Имя']");
    private final By surNameField =By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField =By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroStationField =By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneNumberField =By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By moveNextPage =By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");
    private final By fieldOrderDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By fieldCalendar = By.cssSelector("div.react-datepicker__day--selected");
    private final By fillRentTerm =By.cssSelector("div.Dropdown-placeholder");
    private final By setTermDay =By.xpath(".//div[text()='сутки']");
    private final By setComment =By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By submitOrderPopUp =By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private final By submitOrderPopUpYes =By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    private final By checkSuccessfullyCreatedOrderPopup =By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(),'Заказ оформлен')]");

    public CreateOrderPage(WebDriver driver){
        this.driver = driver;
    }


    public void fillPersonData(String name, String surname, String address, String subway, String phone){

        //Очищаем и заполняем имя
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);

        //Очищаем и заполняем фамилию
        driver.findElement(surNameField).clear();
        driver.findElement(surNameField).sendKeys(surname);

        //Очищаем и заполняем адрес
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);

        //Очищаем и заполняем метро
        driver.findElement(metroStationField).clear();
        driver.findElement(metroStationField).sendKeys(subway);
        driver.findElement(By.xpath(".//div[contains(text(),'"+ subway +"')]"));

        //Очищаем и заполняем телефон
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(phone);
    }

    public void nextPage() {
        driver.findElement(moveNextPage).click();

    }

    public void fillRentDate(String rentDate){
        driver.findElement(fieldOrderDate).clear();
        driver.findElement(fieldOrderDate).sendKeys(rentDate);
        driver.findElement(fieldCalendar).click();
    }

    public void fillRentDateByToday(){
        driver.findElement(fieldOrderDate).clear();
        driver.findElement(fieldOrderDate).sendKeys(TODAY_DATE);
        driver.findElement(fieldCalendar).click();
    }

    public void fillRentTerm(){
        driver.findElement(fillRentTerm).click();
        driver.findElement(setTermDay).click();
    }

    public void fillRentTerm(String term){
        driver.findElement(fillRentTerm).click();
        driver.findElement(By.xpath(".//div[text()='"+ term +"']")).click();
    }

    public void setScooterType(String scooterType){
        if(scooterType != null){
            driver.findElement(By.id(scooterType)).click();
        }
    }

    public void setComment(String comment){
        if(comment != null){
            driver.findElement(setComment).clear();
            driver.findElement(setComment).sendKeys(comment);
        }
    }

    public void submitOrderPopUp(){
        driver.findElement(submitOrderPopUp).click();
    }

    public void submitOrderPopUpYes(){
        driver.findElement(submitOrderPopUpYes).click();
    }

    public boolean checkSuccessfullyCreatedOrderPopup(){
        List<WebElement> finalPopup = driver.findElements(checkSuccessfullyCreatedOrderPopup);
        return finalPopup.size() != 0;
    }
}
