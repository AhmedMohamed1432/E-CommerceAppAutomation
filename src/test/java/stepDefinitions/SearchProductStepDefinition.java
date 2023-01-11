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
import pages.LoggedUserHomePage;
import pages.ResetPasswordPage;

public class SearchProductStepDefinition {
    WebDriver driver =null;
    LoggedUserHomePage loggedUser;
    Logger logger;

    @When("^user enters \"(.*)\" in search field$")
    public void user_enter_Search_Item( String Product ){
        driver = hooks.getDriver();
        loggedUser = new LoggedUserHomePage(driver);
        loggedUser.searchItems().sendKeys(Product);
    }

    @And("user press search button")
    public void user_click_search_button(){
        loggedUser.searchItems().sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("product is displayed")
    public void product_display_success(){
        logger = LoggerFactory.getLogger(SearchProductStepDefinition.class);
        logger.info("Search Result:");

        String expectedRes = "https://demo.nopcommerce.com/search?q=Apple+MacBook";
        String actualRes = driver.getCurrentUrl();
        Assert.assertEquals("Error in search", expectedRes,actualRes);

        if(expectedRes.equals(actualRes)){
            logger.info("Pass");
        }else logger.error("Fail");
    }


}
