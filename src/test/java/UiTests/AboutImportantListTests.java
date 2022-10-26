package UiTests;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AboutImportantListTests {

    WebDriver driver = new FirefoxDriver();


  //  @Before


    @Test
    public void CheckAboutImportantListPanelText(){
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }
    @After
    public void teardown(){
        driver.quit();
    }
}
