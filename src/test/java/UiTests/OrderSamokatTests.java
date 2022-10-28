package UiTests;
import PageObject.OrderForm;
import org.junit.Assert;
import org.junit.Before;
import PageObject.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderSamokatTests {
    //тестовый набор для поля Имя
    private String[] name = {"Сергей","Андрей"};
    //тестовый набор для поля Фамилия
    private String[] lastName = {"Иванов","Ковалев"};
    //тестовый набор для поля Адрес
    private String[] address = {"Кутузовский пр-т, д.38, кв.111","ул.Советская, д.12, кв.43"};
    //тестовый набор для поля Номер телефона
    private String[] phoneNumber = {"+79994445566","+79779632541"};
    //выбор варианта тестовых данных из массивов name, lastName, address, phoneNumber.
    // Для станций метро: 0 - Бульвар Рокоссовского, 1 - Черкизовская.
    //Для выбора даты доставки самоката: 0 - 28 октября, 1 - 29 октября.
    //тестовый набор для поля Комментарий для курьера
    private String[] commentsForCourier = {"Я дома с 18 до 22 часов","Домофон не работает - звоните на телефон"};
    private int variantOfTestData;
    private WebDriver driver;

    @Before
    public void preSettings() {
        System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "C:/WebDriver/bin/geckodriver.exe");
//        driver = new FirefoxDriver();
    }
    @Test
    //Заказ самоката через кнопку "Заказать" в хедере
    public void checkOrderSamokatWithHeaderOrderButton(){
        variantOfTestData = 0;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        //Нажимаем кнопку заказать в хедере
        mainPage.orderHeaderButtonClick();
        //Заполняем форму "Для кого самокат"
        OrderForm orderForm = new OrderForm(driver);
        orderForm.setInputName(name[variantOfTestData]);
        orderForm.setInputLastNameName(lastName[variantOfTestData]);
        orderForm.setInputAdress(address[variantOfTestData]);
        orderForm.setInputMetroStationSelect(variantOfTestData);
        orderForm.setInputPhoneNumber(phoneNumber[variantOfTestData]);
        //Жмем кнопку "Далее"
        orderForm.formOneButtonNextClick();
        //Заполняем форму "Про аренду"
        orderForm.samokatDeliveryDateSelect(variantOfTestData);
        orderForm.rentDurationSelect();
        orderForm.blackCheckBoxSelect();
        orderForm.greyCheckBoxSelect();
        orderForm.setCommentForCourier(commentsForCourier[variantOfTestData]);
        //Жмем кнопку формы "Заказать"
        orderForm.formForRentOrderButtonClick();
        //Жмем кнопку "Да" в модальном окне
        orderForm.modalWindowApproveButtonClick();

        Assert.assertThat(orderForm.checkModalWindowSuccessOrdering(),containsString("Заказ оформлен"));

        }

    @Test
//    //Заказ самоката через кнопку "Заказать" в хедере
    public void checkOrderSamokatWithBodyOrderButton(){
        variantOfTestData = 1;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        //Нажимаем кнопку заказать в хедере
        mainPage.orderBodyButtonClick();
        //Заполняем форму "Для кого самокат"
        OrderForm orderForm = new OrderForm(driver);
        orderForm.setInputName(name[variantOfTestData]);
        orderForm.setInputLastNameName(lastName[variantOfTestData]);
        orderForm.setInputAdress(address[variantOfTestData]);
        orderForm.setInputMetroStationSelect(variantOfTestData);
        orderForm.setInputPhoneNumber(phoneNumber[variantOfTestData]);
        //Жмем кнопку "Далее"
        orderForm.formOneButtonNextClick();
        //Заполняем форму "Про аренду"
        orderForm.samokatDeliveryDateSelect(variantOfTestData);
        orderForm.rentDurationSelect();
        orderForm.blackCheckBoxSelect();
        orderForm.greyCheckBoxSelect();
        orderForm.setCommentForCourier(commentsForCourier[variantOfTestData]);
        //Жмем кнопку формы "Заказать"
        orderForm.formForRentOrderButtonClick();
        //Жмем кнопку "Да" в модальном окне
        orderForm.modalWindowApproveButtonClick();

        Assert.assertThat(orderForm.checkModalWindowSuccessOrdering(),containsString("Заказ оформлен"));
        }

    @After
    public void teardown(){
            driver.quit();
        }


}
