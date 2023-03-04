package pages;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static src.Dates.*;
import static src.RentTerms.*;
import static src.TypesOfScooters.*;

@RunWith(Parameterized.class)
public class CreateOrderWithDifferentPersonalRentDataTest {
    private static WebDriver driver;
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String userSubway;
    private final String userPhone;
    private final String rentDate;
    private final String term;
    private final String scooterType;
    private final String comment;


    public CreateOrderWithDifferentPersonalRentDataTest(String userName,
                                                        String userSurname,
                                                        String userAddress,
                                                        String userSubway,
                                                        String userPhone,
                                                        String rentDate,
                                                        String term,
                                                        String scooterType,
                                                        String comment){
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.userSubway = userSubway;
        this.userPhone = userPhone;
        this.rentDate = rentDate;
        this.term = term;
        this.scooterType = scooterType;
        this.comment = comment;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getSumData() {
        return new Object[][] {
                { "Андрей", "Андреевич", "Москва", "Черкизовская", "88005553535", TODAY_DATE, ONE_DAY, BLACK_SCOOTER, "test-privet" },
                { "Сергей", "Саныч", "Казань", "Сокольники", "11111111111", TOMORROW_DATE, TWO_DAYS, null, "privet medved" },
                { "Михал", "Михалыч", "Челябинск", "Чистые пруды", "555555555555", YESTERDAY_DATE, ONE_DAY, GRAY_SCOOTER, null },
                { "Иван", "Иванович", "Сочи", "Лубянка", "89994568877", TODAY_DATE, THREE_DAYS, null, null },
        };
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void createOrderWithDifferentPersonalRentData(){
        MainPage page = new MainPage(driver);

        page.open();
        page.createOrderTop();

        CreateOrderPage order = new CreateOrderPage(driver);

        order.fillPersonData(userName, userSurname, userAddress, userSubway, userPhone);
        order.nextPage();
        order.fillRentDate(rentDate);
        order.fillRentTerm(term);
        order.setScooterType(scooterType);
        order.setComment(comment);
        order.submitOrderPopUp();
        order.submitOrderPopUpYes();

        Assert.assertTrue("Окно успешного создания заказа не отобразилось", order.checkSuccessfullyCreatedOrderPopup());
    }

    @After
    public void cleanUp(){
        driver.quit();
    }

}