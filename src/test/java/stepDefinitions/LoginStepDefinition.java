package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

public class LoginStepDefinition {
    WebDriver driver =null;
    LoginPage login;
    Logger logger;
    @Given("user navigate to login page")
    public void User_navigate_to_login(){
        driver = hooks.getDriver();
        if(driver!=null) {
            login = new LoginPage(driver);
            driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        }
    }

    @When("^user enters valid login data \"(.*)\", and \"(.*)\"$")
    public void user_enter_valid_login_data( String Email, String password ){
        login.loginSteps(Email,password);

    }
    @And("user clicks login button")
    public void login_button(){
        login.password().sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("user login success and navigate to home page")
    public void login_result(){
        logger = LoggerFactory.getLogger(LoginStepDefinition.class);
        logger.info("Login Result:");
        if(driver!=null) {
            Assert.assertEquals("https://demo.nopcommerce.com/",
                    driver.getCurrentUrl());

            if (driver.getCurrentUrl().equals("https://demo.nopcommerce.com/"))
                logger.info("Pass");
            else logger.error("Fail");
        }
    }



}
