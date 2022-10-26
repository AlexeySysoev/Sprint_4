package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    //кнопка "Заказать" в хедере
    private final By orderHeaderButton = By.className("Button_Button__ra12g");
    //кнопка "Заказать" в контенте
    private final By orderBodyButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");
    //элемент списка "Вопросы о важном" - заготовка (accordion__heading-0)
    private final String liAboutImportante ="accordion__heading-";
    //ответ на вопрос списка "Вопросы о важном" - заготовка (accordion__panel-0)
    private final String liAnswerPanelText = "accordion__panel-";

    //конструктор класса
    public MainPage (WebDriver driver){
        this.driver = driver;
    }
    //клик по кнопке "Заказать" в хедере
    public void orderHeaderButtonClick(By orderHeaderButton){
        driver.findElement(orderHeaderButton).click();
    }
    //клик по кнопке "Заказать" в контенте
    public void orderBodyButtonClick(By orderBodyButton){
        driver.findElement(orderBodyButton).click();
    }
    //клик по элементу списка "Вопросы о важном"
    public void liAboutImportanteClick(String liNumber) {
        driver.findElement(By.id(liAboutImportante+liNumber)).click();
    }
    public void liAnswerPanelGetText (String AnswerNumber){
        driver.findElement(By.id(liAnswerPanelText+AnswerNumber)).getText();
    }
}
