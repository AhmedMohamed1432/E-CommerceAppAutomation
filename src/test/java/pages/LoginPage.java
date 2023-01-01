package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement email(){
        By email = By.id("Email");
        return driver.findElement(email);
    }

    public WebElement password(){
        By password = By.id("Password");
        return driver.findElement(password);
    }


    public void loginSteps( String email, String password){

        email().clear();
        email().sendKeys(email);
        password().clear();
        password().sendKeys(password);

    }

}
