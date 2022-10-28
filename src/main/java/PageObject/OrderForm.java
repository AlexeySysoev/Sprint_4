package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderForm {
    /* Локаторы формы "Для кого самокат"*/
    //инпут Имя
    private By inputName = By.xpath(".//div/input[@placeholder='* Имя']");
    //инпут Фамилия
    private By inputLastName = By.xpath(".//div/input[@placeholder='* Фамилия']");
    //инпут Адрес
    private By inputAdress = By.xpath(".//div/input[contains(@placeholder,'Адрес')]");
    //инпут Селектора станций метро
    private By inputMetroStationSelect = By.xpath(".//div/input[@class='select-search__input']");
    //инпут номера телефона
    private By inputPhoneNumber = By.xpath(".//div/input[contains(@placeholder,'Телефон')]");
    //выбор станций метро из селектора
    private By[] metroStationSelect = {By.xpath(".//div[@class='select-search__select']//div[text()='Бульвар Рокоссовского']"),
                                       By.xpath(".//div[@class='select-search__select']//div[text()='Черкизовская']")
    };
    //кнопка Далее
    private By formOneButtonNext = By.xpath(".//button[text()='Далее']");
    /* Локаторы формы "Про аренду"*/
    //инпут Когда привезти самокат
    private By samokatDeliveryDate = By.xpath(".//input[contains(@placeholder,'Когда привезти самокат')]");
    //инпут Срок аренды
    private By rentDurationInput = By.xpath(".//div[contains(text(),'Срок аренды')]");
    //элемент селектора Срока аренды
    private By rentDurationSelector = By.xpath(".//div[text()='сутки']");
    //чекбокс выбора цвета - черный
    private By blackColourCheckBox = By.xpath(".//input[@id='black']");
    //чекбокс выбора цвета - серая безисходность
    private By greyColourCheckBox = By.xpath(".//input[@id='grey']");
    //инпут Комментарий
    private By commentForCourier = By.xpath(".//input[contains(@placeholder,'Комментарий')]");
    //Кнопка формы Про аренду "Заказать"
    private By formForRentOrderButton = By.xpath(".//div[@class='Order_Content__bmtHS']//button[text()='Заказать']");
    //Кнопка "Да" модального окна подтверждения заказа
    private By modalWindowApproveButton = By.xpath(".//button[text()='Да']");
    private WebDriver driver;
    //конструктор
    public OrderForm (WebDriver driver){
        this.driver = driver;
    }
    /* Форма "Для кого самокат" */

    //ввод значения в поле Имя
    public void setInputName(String name){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(inputName));
        driver.findElement(inputName).sendKeys(name);
    }
    //ввод значения в поле Фамилия
    public void setInputLastNameName(String lastName){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(inputLastName));
        driver.findElement(inputLastName).sendKeys(lastName);
    }
    //ввод значения в поле Адрес
    public void setInputAdress(String adress){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(inputAdress));
        driver.findElement(inputAdress).sendKeys(adress);
    }
    //ввод значения в поле Телефон
    public void setInputPhoneNumber(String phoneNumber){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(inputPhoneNumber));
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
    }
    //выбор станции метро из селектора Метро
    public void setInputMetroStationSelect(int variantOfTestData){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(inputMetroStationSelect));
        driver.findElement(inputMetroStationSelect).click();
        driver.findElement(metroStationSelect[variantOfTestData]).click();
    }
    //нажатие кнопки Далее
    public void formOneButtonNextClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(formOneButtonNext));
        driver.findElement(formOneButtonNext).click();
    }
    /* Форма "Про аренду" */
    //выбор даты доставки
    public void samokatDeliveryDateSelect(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(samokatDeliveryDate));
        driver.findElement(samokatDeliveryDate).click();
        driver.findElement(By.xpath(".//div[contains(@aria-label, '28')]")).click();
    }
    //выбор срока аренды
    public void rentDurationSelect() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(rentDurationInput));
        driver.findElement(rentDurationInput).click();
        driver.findElement(rentDurationSelector).click();
    }
     //выбор черного чекбокса
    public void blackCheckBoxSelect(){
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(blackColourCheckBox));
            driver.findElement(blackColourCheckBox).click();
        }
     //выбор серого чекбокса
    public void greyCheckBoxSelect(){
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(greyColourCheckBox));
            driver.findElement(greyColourCheckBox).click();
        }
    //заполнение поля Комментарий для курьера
    public void setCommentForCourier(String commentsForCourier){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(commentForCourier));
        driver.findElement(commentForCourier).sendKeys(commentsForCourier);
    }
    public void formForRentOrderButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(formForRentOrderButton));
        driver.findElement(formForRentOrderButton).click();
    }
    public void modalWindowApproveButtonClick(){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(modalWindowApproveButton));
        driver.findElement(modalWindowApproveButton).click();
    }

    }

