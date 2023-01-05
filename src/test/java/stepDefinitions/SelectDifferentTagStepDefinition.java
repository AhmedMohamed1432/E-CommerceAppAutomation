package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserHomePage;
import pages.ProductTagPage;

public class SelectDifferentTagStepDefinition {
    WebDriver driver =null;
    ProductTagPage productTagPage;
    Logger logger;

    @Given("user navigate to product tags")
    public void product_tags_page(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/producttag/all");
    }

    @When("user select product tag")
    public void select_product_tag(){
        productTagPage.productTag().click();
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

        String expectedUrl = "https://demo.nopcommerce.com/awesome";

        Assert.assertEquals("Selected product tag error!",
                expectedUrl,
                driver.getCurrentUrl());

        if(expectedUrl.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");
    }

    @After
    public void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
