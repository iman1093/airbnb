package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static utils.DriverFactory.getChromeDriver;

public class BaseTests {
    private WebDriver driver;

    @BeforeSuite
    public void setUp(){
        driver = getChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://www.airbnb.com/");
    }

//    @AfterSuite
//    public void tearDown(){
//        driver.quit();
//    }
}
