package utils;

import org.openqa.selenium.WebDriver;

public class NavigateMethods {

    private final WebDriver driver;

    public NavigateMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateBack(){
        driver.navigate().back();
        System.out.println("back");
    }
}
