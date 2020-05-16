package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;
import pages.HomePage;
import utils.NavigateMethods;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    @BeforeMethod
    public void startDriver(){
        // noinspection SpellCheckingInspection
        System.setProperty("webdriver.opera.driver", "src\\main\\java\\resources\\drivers\\operadriver.exe");
        driver = new OperaDriver();
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public NavigateMethods windowManager(){
        return new NavigateMethods(driver);
    }

    public void getHome(){
        driver.get("https://the-internet.herokuapp.com");
    }

}
