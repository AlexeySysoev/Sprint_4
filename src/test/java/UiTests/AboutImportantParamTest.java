package UiTests;
import org.junit.Assert;
import org.junit.Before;
import PageObject.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class AboutImportantParamTest{
    private WebDriver driver;
    private final String answerText;
    private final int liQuestionNumber;

    public AboutImportantParamTest(String answerText, int liQuestionNumber){
        this.answerText = answerText;
        this.liQuestionNumber = liQuestionNumber;
    }

    @Parameterized.Parameters
    public static Object[][] accordeonPanelText(){
        //Данные ответов, второй параметр для запроса номера вопроса
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7}
        };
    }
    @Before
    public void preSettings(){
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver","C:/WebDriver/bin/geckodriver.exe");
//        driver = new FirefoxDriver();
    }
    @Test
    public void checkAnswerText(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.scroll(liQuestionNumber);
        mainPage.waitQuestion(liQuestionNumber);
        mainPage.liAboutImportantClick(liQuestionNumber);
        mainPage.waitAnswerText(liQuestionNumber);
        //проверка соответствия ответов номеру вопроса
        Assert.assertEquals(answerText, mainPage.liAnswerPanelGetText(liQuestionNumber));
    }
    @After
    public void teardown(){
        driver.quit();
    }
}