package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    //URL
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    //кнопка "Заказать" в хедере
    private final By orderHeaderButton = By.xpath(".//Button[@class='Button_Button__ra12g']");
    //кнопка "Заказать" в контенте
    private final By orderBodyButton = By.xpath(".//Button[contains(@class, 'Button_Middle__1CSJM')]");
    //элемент списка "Вопросы о важном" - заготовка (accordion__heading-0)
    private final String liAboutImportante ="accordion__heading-";
    //ответ на вопрос списка "Вопросы о важном" - заготовка (accordion__panel-0)
    private final String liAnswerPanelText = "accordion__panel-";

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
    public void liAboutImportanteClick(String liNumber) {
        driver.findElement(By.id(liAboutImportante+liNumber)).click();
    }
    //получение текста с ответом
    public String liAnswerPanelGetText (String AnswerNumber){
        return driver.findElement(By.id(liAnswerPanelText+AnswerNumber)).getText();
    }
}
