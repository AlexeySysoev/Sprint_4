package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    //Локаторы Вопросов списка Вопросов о важном
    private By[] aboutImpotantQuestionXpath = {By.xpath(".//div[@id='accordion__heading-0']"),
            By.xpath(".//div[@id='accordion__heading-1']"),
            By.xpath(".//div[@id='accordion__heading-2']"),
            By.xpath(".//div[@id='accordion__heading-3']"),
            By.xpath(".//div[@id='accordion__heading-4']"),
            By.xpath(".//div[@id='accordion__heading-5']"),
            By.xpath(".//div[@id='accordion__heading-6']"),
            By.xpath(".//div[@id='accordion__heading-7']")};

    //Локаторы Ответов списка Вопросов о важном
    private By[] aboutImpotantAnswerXpath = {By.xpath(".//div[@id='accordion__panel-0']/p"),
            By.xpath(".//div[@id='accordion__panel-1']/p"),
            By.xpath(".//div[@id='accordion__panel-2']/p"),
            By.xpath(".//div[@id='accordion__panel-3']/p"),
            By.xpath(".//div[@id='accordion__panel-4']/p"),
            By.xpath(".//div[@id='accordion__panel-5']/p"),
            By.xpath(".//div[@id='accordion__panel-6']/p"),
            By.xpath(".//div[@id='accordion__panel-7']/p")};

    //Адрес сайта "Самокат"
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    //кнопка "Заказать" в хедере
    private final By orderHeaderButton = By.xpath(".//Button[@class='Button_Button__ra12g']");
    //кнопка "Заказать" в контенте
    private final By orderBodyButton = By.xpath(".//Button[contains(@class, 'Button_Middle__1CSJM')]");

    //конструктор класса
    public MainPage (WebDriver driver){
        this.driver = driver;
    }
    //
    public void open(){
        driver.get(url);
    }
    //клик по кнопке "Заказать" в хедере
    public void orderHeaderButtonClick(){
        driver.findElement(orderHeaderButton).click();
    }
    //клик по кнопке "Заказать" в контенте
    public void orderBodyButtonClick(){
        driver.findElement(orderBodyButton).click();
    }
    //клик по элементу списка "Вопросы о важном"
    public void liAboutImportantClick(int questionNumber) {
        driver.findElement(aboutImpotantQuestionXpath[questionNumber]).click();
    }
    //получение текста с ответом
    public String liAnswerPanelGetText (int questionNumber){
       return driver.findElement(aboutImpotantAnswerXpath[questionNumber]).getText();
    }
    public void scroll(int questionNumber){
        WebElement element = driver.findElement(aboutImpotantQuestionXpath[questionNumber]);
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView();",
                        element
                );
    }
    public void waitQuestion (int questionNumber){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(aboutImpotantQuestionXpath[questionNumber]));
    }
    public void waitAnswerText (int questionNumber){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(aboutImpotantAnswerXpath[questionNumber]));

    }
}
