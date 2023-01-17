package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserHomePage;

public class AddToCompareListDefinition {
    WebDriver driver =null;
    LoggedUserHomePage loggedUser;
    Logger logger;

    @When("user select Add to compare list button")
    public void addToComp_button(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUser = new LoggedUserHomePage(driver);
        loggedUser.addToCompareList().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user success to add selected product to compare list")
    public void successAddingProduct(){
        logger = LoggerFactory.getLogger(AddToCompareListDefinition.class);
        logger.info("Add to compare list Result:");

        String successMsg = loggedUser.addToCompareListSuccess().getText();
        String expectedMsgPart = "The product has been added to your";
        String compareName = loggedUser.compareLink().getText();

        Assert.assertTrue("Add product to shopping cart Error!",
                successMsg.contains(expectedMsgPart));
        Assert.assertEquals("product comparison", compareName);

        if(successMsg.contains(expectedMsgPart)){
            logger.info("Pass");
        }else logger.error("Fail");
    }



}
