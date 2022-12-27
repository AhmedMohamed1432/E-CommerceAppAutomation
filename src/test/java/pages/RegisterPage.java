package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement firstName(){
        By firstName = By.id("FirstName");
        return driver.findElement(firstName);
    }

    public WebElement lastName(){
        By lastName = By.id("LastName");
        return driver.findElement(lastName);
    }

    public WebElement email(){
        By email = By.id("Email");
        return driver.findElement(email);
    }

    public WebElement password(){
        By password = By.id("Password");
        return driver.findElement(password);
    }

    public WebElement confirmPassword() {
        By confirmPassword = By.id("ConfirmPassword");
        return driver.findElement(confirmPassword);
    }
    public WebElement successResult(){
        By successResult = By.cssSelector("div>div[class=\"result\"]");
        return driver.findElement(successResult);
    }

    public WebElement continueButton(){
        By continueButton = By.className("register-continue-button");
        return driver.findElement(continueButton);
    }
    public void registerSteps(String FName, String LName, String email, String password, String passwordConfirm){
        firstName().clear();
        lastName().clear();
        email().clear();
        password().clear();
        confirmPassword().clear();

        firstName().sendKeys(FName);
        lastName().sendKeys(LName);
        email().sendKeys(email);
        password().sendKeys(password);
        confirmPassword().sendKeys(passwordConfirm);
    }

}
