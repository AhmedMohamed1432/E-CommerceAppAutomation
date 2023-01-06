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
import pages.ResetPasswordPage;

public class ResetPasswordStepDefinition {
    WebDriver driver =null;
    ResetPasswordPage resetpass ;
    Logger logger;
    @Given("user press forgotPassword link")
    public void User_navigate_to_resetpassword(){
        driver = hooks.getDriver();
        resetpass = new ResetPasswordPage(driver);
        //go to login page
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
        resetpass.forgotPasswordLink().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("^user enters reset email \"(.*)\"$")
    public void user_enter_email( String Email ){
        resetpass.resetPasswordSteps(Email);
    }

    @And("user click reset button")
    public void user_click_reset_button(){
        resetpass.email().sendKeys(Keys.ENTER);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("success message is displayed")
    public void reset_password_success(){
        logger = LoggerFactory.getLogger(ResetPasswordStepDefinition.class);
        logger.info("Reset Password Result:");

        String successResult = resetpass.successResult().getText();
        System.out.println(successResult);
        Assert.assertTrue("Error in reset password!",
                successResult.contains("Email with instructions has been sent to you."));
        if(successResult.contains("Email with instructions has been sent to you.")){
            logger.info("Pass");
        }else logger.error("Fail reset password");
    }

}
