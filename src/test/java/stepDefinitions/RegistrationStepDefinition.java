package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.RegisterPage;

public class RegistrationStepDefinition {
    WebDriver driver =null;
    RegisterPage register;
    Logger logger;
    @Given("User open browser")
    public void User_open_browser(){

        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = hooks.getDriver();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @And("user navigate to register page")
    public void user_navigate_to_register_page(){
        register = new RegisterPage(driver);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }

    @When("^user enter valid data \"(.*)\" , \"(.*)\", \"(.*)\", \"(.*)\" and \"(.*)\"$")
    public void user_enter_valid_data(String FName, String LName, String Email, String password , String passwordConfirm){
        register.registerSteps(FName,LName, Email,password,passwordConfirm);

    }
    @And("user click on register button")
    public void register_button(){
        register.confirmPassword().sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("user go to successful register page")
    public void register_result(){
        logger = LoggerFactory.getLogger(RegistrationStepDefinition.class);
        logger.info("Register Result:");
        String actualResult = register.successResult().getText();
        Assert.assertEquals("Success message Error",
                "Your registration completed",
                actualResult);
        if(actualResult.contains("Your registration completed")){
            logger.info("Pass");
        }else logger.error("Fail");
    }
    @When("user clicks continue button")
    public void continue_button(){
        register.continueButton().click();
    }
    @Then("user navigate to home page")
    public void navigate_to_homepage(){
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
    }

}
