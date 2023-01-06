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
import pages.LoggedUserHomePage;

public class SelectCategoryStepDefinition {
    WebDriver driver =null;
    LoggedUserHomePage loggedUser;
    WebElement categoryList, subCategory;
    Actions actions;
    Logger logger;

    @When("user hover to Computers")
    public void user_Select_category( ){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUser = new LoggedUserHomePage(driver);

        categoryList = loggedUser.categoryList();
        actions = new Actions(driver);
        actions.moveToElement(categoryList);
    }
    @And("user select Notebooks category")
    public void user_select_notebooks (){
        subCategory = loggedUser.subCategory();
        actions.moveToElement(subCategory);

        actions.click().build().perform();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to Notebooks category page")
    public void got_to_homePage(){
        logger = LoggerFactory.getLogger(SelectCategoryStepDefinition.class);
        logger.info("Select Category Result:");

        String expecredRes = "https://demo.nopcommerce.com/notebooks";

        Assert.assertEquals("Select Category error!",
                expecredRes, driver.getCurrentUrl());

        if(expecredRes.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");

    }


}
