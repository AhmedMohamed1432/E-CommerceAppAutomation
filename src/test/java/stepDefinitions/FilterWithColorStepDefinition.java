package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserCategoryPage;
import pages.LoggedUserHomePage;

public class FilterWithColorStepDefinition {
    WebDriver driver =null;
    LoggedUserCategoryPage lUserCategory;
    Logger logger;

    @When("user selects color")
    public void user_Select_color(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/shoes");
        lUserCategory = new LoggedUserCategoryPage(driver);
        lUserCategory.selectedColor().click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("user see products with selected colors")
    public void select_color_product(){
        logger = LoggerFactory.getLogger(FilterWithColorStepDefinition.class);
        logger.info("Colored product Result:");
        String expectedUrl = "https://demo.nopcommerce.com/shoes?viewmode=grid&orderby=0&pagesize=6&specs=15";
        Assert.assertEquals("Products with selected colors error!",
                expectedUrl, driver.getCurrentUrl());

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
