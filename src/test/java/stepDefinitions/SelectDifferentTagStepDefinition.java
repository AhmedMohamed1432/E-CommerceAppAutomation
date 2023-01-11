package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @When("user selects a product tag")
    public void select_product_tagg(){
        productTagPage.tags().click();
        //driver.findElement(By.linkText("Apparel")).click();
        //driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/ul/li[1]/a")).click();

        try {
            Thread.sleep(3000);
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
