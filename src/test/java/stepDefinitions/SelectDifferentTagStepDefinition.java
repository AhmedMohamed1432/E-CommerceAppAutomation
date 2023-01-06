package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserHomePage;
import pages.ProductTagPage;

public class SelectDifferentTagStepDefinition {
    WebDriver driver =null;
    ProductTagPage productTagPage;
    LoggedUserHomePage homepage;
    Logger logger;
    WebElement productTag;
    Actions actions;
    @Given("user navigate to product tags")
    public void product_tags_page(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/producttag/all");
    }

    @When("user click product tag")
    public void select_product_tag(){
        productTagPage.tags().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to selected product tag page")
    public void selected_productTag_page(){
        logger = LoggerFactory.getLogger(SelectDifferentTagStepDefinition.class);
        logger.info("Select Product Tag Result:");

        String expectedUrl = "https://demo.nopcommerce.com/producttag/apparel-2";

        Assert.assertEquals("Selected product tag error!",
                expectedUrl,
                driver.getCurrentUrl());

        if(expectedUrl.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");
    }


}
