package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserHomePage;

public class AddToWishListDefinition {
    WebDriver driver =null;
    LoggedUserHomePage loggedUser;
    Logger logger;

    @When("user select Add to Wishlist button")
    public void addToWish_button(){
        driver = hooks.getDriver();
        if(driver!= null) {
            driver.get("https://demo.nopcommerce.com/");
            loggedUser = new LoggedUserHomePage(driver);
            loggedUser.addToWishlist().click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @When("user select Add to wishlist button in product page")
    public void add_to_wishlist_button(){
        loggedUser.addToWishlistButton().click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user success to add selected product to Wishlist")
    public void successAddingProduct(){
        logger = LoggerFactory.getLogger(AddToWishListDefinition.class);
        logger.info("Add to wishlist Result:");

        String successMsg = loggedUser.addToWishlistSuccess().getText();
        String expectedMsgPart = "The product has been added to your ";
        String wishlistName = loggedUser.wishLink().getText();

        Assert.assertTrue("Add product to wishlist error",
                successMsg.contains(expectedMsgPart));
        Assert.assertEquals("wishlist",wishlistName);

        if(successMsg.contains(expectedMsgPart)){
            logger.info("Adding to wishlist success");
        }else logger.error("Fail adding to list!");
    }


}
