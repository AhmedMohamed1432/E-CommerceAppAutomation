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
    LoggedUserHomePage loggedUserhome;
    WebElement categoryList, subCategory;
    Actions actions;
    Logger logger;

    @When("user hover to Computers")
    public void user_Select_category( ){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUserhome = new LoggedUserHomePage(driver);
        categoryList = loggedUserhome.categoryList();
        actions = new Actions(driver);
        actions.moveToElement(categoryList);
    }
    @And("user select Notebooks category")
    public void user_select_notebooks (){
        //steps to access subcategory
        subCategory = loggedUserhome.subCategoryaccess();
        actions.moveToElement(subCategory);
        actions.click().build().perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to Notebooks category page")
    public void got_to_homePage(){
        logger = LoggerFactory.getLogger(SelectCategoryStepDefinition.class);
        logger.info("Select Category Result:");
        String expectedRes = "https://demo.nopcommerce.com/notebooks";
        Assert.assertEquals("Select Category error!",
                expectedRes, driver.getCurrentUrl());

        if(expectedRes.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");

    }

}
