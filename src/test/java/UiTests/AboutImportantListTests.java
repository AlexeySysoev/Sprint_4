package UiTests;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.containsString;
//import org.junit.Assert;
import org.junit.Assert;
import org.junit.Before;
import PageObject.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
//import java.util.regex.Matcher;


public class AboutImportantListTests {
    WebDriver driver;
    String expected;
    String result;
    @Before
    public void preSettings(){
        System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkAboutImportantListPanelText(){
        //driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView();",
                        element
                );

        //mainPage.liAboutImportanteClick("0");
        driver.findElement(By.xpath(".//div[@id='accordion__heading-0']")).click();
        expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        result = driver.findElement(By.xpath(".//div[@id='accordion__panel-0']/p")).getText();
        Assert.assertEquals(expected, result);



    }
    @After
    public void teardown(){
        driver.quit();
    }
}
