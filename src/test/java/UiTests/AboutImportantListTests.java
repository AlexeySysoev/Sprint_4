package UiTests;
import org.junit.Assert;
import org.junit.Before;
import PageObject.MainPage;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;




public class AboutImportantListTests {
    private WebDriver driver;
    private String[] expectedArr = {
        "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
        "Да, обязательно. Всем самокатов! И Москве, и Московской области."};
    private int questionNumber;

    @Before
    public void preSettings(){
        System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver","C:/WebDriver/bin/geckodriver.exe");
        driver = new ChromeDriver();
        /*driver = new FirefoxDriver();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(false);*/

    }

    @Test
    public void checkAboutImportantQuestionsPriceAnswerText(){
        questionNumber = 0;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scroll(questionNumber);
        mainPage.liAboutImportantClick(questionNumber);
        mainPage.wait(questionNumber);
        Assert.assertEquals(expectedArr[questionNumber], mainPage.liAnswerPanelGetText(questionNumber));

    }

    @Test
    public void checkAboutImportantQuestionsCountAnswerText(){
        questionNumber = 1;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scroll(questionNumber);
        mainPage.liAboutImportantClick(questionNumber);
        mainPage.wait(questionNumber);
        Assert.assertEquals(expectedArr[questionNumber], mainPage.liAnswerPanelGetText(questionNumber));

    }

    @Test
    public void checkAboutImportantQuestionsRentAnswerText(){
        questionNumber = 2;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scroll(questionNumber);
        mainPage.liAboutImportantClick(questionNumber);
        mainPage.wait(questionNumber);
        Assert.assertEquals(expectedArr[questionNumber], mainPage.liAnswerPanelGetText(questionNumber));

    }
    @Test
    public void checkAboutImportantQuestionsDateOfOrderAnswerText() {
        questionNumber = 3;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scroll(questionNumber);
        mainPage.liAboutImportantClick(questionNumber);
        mainPage.wait(questionNumber);
        Assert.assertEquals(expectedArr[questionNumber], mainPage.liAnswerPanelGetText(questionNumber));
    }
    @Test
    public void checkAboutImportantQuestionsChangeOrderAnswerText(){
        questionNumber = 4;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scroll(questionNumber);
        mainPage.liAboutImportantClick(questionNumber);
        mainPage.wait(questionNumber);
        Assert.assertEquals(expectedArr[questionNumber], mainPage.liAnswerPanelGetText(questionNumber));
    }

    @Test
    public void checkAboutImportantQuestionsChargePowerAnswerText(){
        questionNumber = 5;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scroll(questionNumber);
        mainPage.liAboutImportantClick(questionNumber);
        mainPage.wait(questionNumber);
        Assert.assertEquals(expectedArr[questionNumber], mainPage.liAnswerPanelGetText(questionNumber));
    }

    @Test
    public void checkAboutImportantQuestionsCancelOrderAnswerText(){
        questionNumber = 6;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scroll(questionNumber);
        mainPage.liAboutImportantClick(questionNumber);
        mainPage.wait(questionNumber);
        Assert.assertEquals(expectedArr[questionNumber], mainPage.liAnswerPanelGetText(questionNumber));
    }
    @Test
    public void checkAboutImportantQuestionsLocationDeliveryAnswerText(){
        questionNumber = 7;
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scroll(questionNumber);
        mainPage.liAboutImportantClick(questionNumber);
        mainPage.wait(questionNumber);
        Assert.assertEquals(expectedArr[questionNumber], mainPage.liAnswerPanelGetText(questionNumber));
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
