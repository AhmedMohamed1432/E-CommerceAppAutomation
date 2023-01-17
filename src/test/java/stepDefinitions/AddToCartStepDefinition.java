package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserHomePage;

public class AddToCartStepDefinition {
    WebDriver driver =null;
    LoggedUserHomePage loggedUser;
    Logger logger;

    @When("user select Add to cart button")
    public void addToCart_button(){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUser = new LoggedUserHomePage(driver);
        loggedUser.addToCart().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("user go to product page")
    public void go_to_product_page(){
        if(driver!=null)
            Assert.assertEquals("https://demo.nopcommerce.com/apple-macbook-pro-13-inch",
                    driver.getCurrentUrl());
    }
    @When("user select Add to cart button in product page")
    public void Add_to_cart_button_PP(){
        loggedUser.addToCartButton().click();
    }

    @Then("user success to add selected product to Shopping cart")
    public void successAddingProduct(){
        logger = LoggerFactory.getLogger(AddToCartStepDefinition.class);
        logger.info("Add to Shopping cart Result:");
        String successMsg = loggedUser.addToCartSuccess().getText();
        String expectedMsgPart = "The product has been added to your ";
        String shoppingCartName = loggedUser.cartLink().getText();
        Assert.assertTrue("Add product to shopping cart error",
                successMsg.contains(expectedMsgPart));
        Assert.assertEquals("shopping cart", shoppingCartName);
        if(successMsg.contains(expectedMsgPart)){
            logger.info("Pass");
        }else logger.error("Fail ");
    }


}
