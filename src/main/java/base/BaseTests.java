package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.*;
import pages.HomePage;
import utils.NavigateMethods;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void startDriver() {
        // noinspection SpellCheckingInspection
        System.setProperty("webdriver.opera.driver", "src\\main\\java\\resources\\drivers\\operadriver.exe");
        driver = new OperaDriver();
        goHome();
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("src\\main\\java\\resources\\screenshots\\"
                        +  result.getName() + "-" + getDateTime() +  ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public NavigateMethods windowManager() {
        return new NavigateMethods(driver);
    }

    public String getDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

}
