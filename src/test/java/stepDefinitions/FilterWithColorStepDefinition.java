package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserCategoryPage;

public class FilterWithColorStepDefinition {
    WebDriver driver =null;
    LoggedUserCategoryPage loggedUserCategory;
    Logger logger;

    @When("user selects color")
    public void user_Select_color(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/shoes");
        loggedUserCategory = new LoggedUserCategoryPage(driver);
        loggedUserCategory.selectedColor().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user see products with selected colors")
    public void select_color_product(){
        logger = LoggerFactory.getLogger(FilterWithColorStepDefinition.class);
        logger.info("Colored product Result:");
        String expurl = "https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=15";
        Assert.assertEquals("Product Select color Error!",
                expurl, driver.getCurrentUrl());

        if(expurl.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");

    }


}
