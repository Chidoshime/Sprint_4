package pages;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import src.BaseTest;

import static pages.MainPage.BOTTOM_ORDER_BUTTON;
import static pages.MainPage.TOP_ORDER_BUTTON;

@RunWith(Parameterized.class)
public class CreateOrderThroughDifferentButtonsTest extends BaseTest {
    private final String orderButtonXpath;

    public CreateOrderThroughDifferentButtonsTest(String orderButtonXpath){
        this.orderButtonXpath = orderButtonXpath;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                { TOP_ORDER_BUTTON},
                { BOTTOM_ORDER_BUTTON},
        };
    }

    // По результатам теста, заказать самокат через хром не удается, здесь баг
    @Test
    public void createOrderThroughDifferentButtons() {
        MainPage page = new MainPage(driver);

        page.open();

        WebElement orderButton = driver.findElement(By.xpath(orderButtonXpath));
        page.scrollToElement(orderButton);
        orderButton.click();

        CreateOrderPage order = new CreateOrderPage(driver);

        order.fillPersonData("Василий", "Петрович", "Москва", "Черкизовская", "12345678900");
        order.nextPage();
        order.fillRentDateByToday();
        order.fillRentTerm();
        order.submitOrderPopUp();
        order.submitOrderPopUpYes();

        Assert.assertTrue("Окно успешного создания заказа не отобразилось", order.checkSuccessfullyCreatedOrderPopup());
    }
}