package training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WizelineEasyTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void testEasy(){
        driver.get("https://www.wizeline.com/");
        String title = driver.getTitle();
        AssertJUnit.assertTrue(title.contains("Wizeline | Digital Transformation & Product Development Services"));
    }

    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}