package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By basicAuth = By.linkText("Basic Auth");

    public BasicAuth clickBasicAuth() {
        driver.findElement(basicAuth).click();
        return new BasicAuth(driver);
    }
}
