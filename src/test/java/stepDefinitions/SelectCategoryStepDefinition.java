package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserHomePage;

public class SelectCategoryStepDefinition {
    WebDriver driver =null;
    LoggedUserHomePage loggedUserhome;
    Actions actions;
    Logger logger;

    @When("user go to Computers in list")
    public void user_goto_categories(){
        driver= hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUserhome = new LoggedUserHomePage(driver);
        actions= new Actions(driver);
        actions.moveToElement(loggedUserhome.categoryList());
    }

    @And("user select Notebooks category")
    public void user_select_category(){
        actions.moveToElement(loggedUserhome.subCategoryaccess());
        actions.click().build().perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("user go to Notebooks category page")
    public void go_to_homepage(){
        logger= LoggerFactory.getLogger(SelectCategoryStepDefinition.class);
        logger.info("Select Category Result:");
        String expurl= "https://demo.nopcommerce.com/notebooks";
        Assert.assertEquals("Select Category Error!",
                expurl, driver.getCurrentUrl());

        if(expurl.equals(driver.getCurrentUrl())){
            logger.info("Pass");
        }else logger.error("Fail");
    }


}
