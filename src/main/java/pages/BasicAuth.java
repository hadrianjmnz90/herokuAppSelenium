package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuth {
    private final WebDriver driver;

    public BasicAuth(WebDriver driver) {
        this.driver = driver;
    }

    By successText = By.xpath("//*[contains(text(), 'Congratulations! You must have the proper credentials.')]");

    public void handleAuthAlert(String username, String password)  {
        //noinspection SpellCheckingInspection
        driver.get("https://"+ username + ":" + password +"@the-internet.herokuapp.com/basic_auth");
    }

    public String getConfirmText(){
        return driver.findElement(successText).getText();
    }
}
