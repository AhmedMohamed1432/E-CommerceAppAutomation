package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoggedUserHomePage;

public class SwitchCurrenciesStepDefinition {
    WebDriver driver =null;
    LoggedUserHomePage loggedUser;
    Logger logger;

    @When("user change customer currency")
    public void user_change_currency( String Product ){
        driver = hooks.getDriver();
        driver.get("https://demo.nopcommerce.com/");
        loggedUser = new LoggedUserHomePage(driver);
        WebElement currencyList = loggedUser.CurrencyOption();
        Select select = new Select(currencyList);
        String option = select.getFirstSelectedOption().getText();
        System.out.println("Option was "+   option);
        select.selectByVisibleText("Euro");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Item price change")
    public void price_change_success(){
        logger = LoggerFactory.getLogger(SwitchCurrenciesStepDefinition.class);
        logger.info("Switch Currency Result:");

        String price = loggedUser.changeCurrency().getText();

        WebElement currencyList = loggedUser.CurrencyOption();
        Select select = new Select(currencyList);
        String option = select.getFirstSelectedOption().getText();
        Assert.assertTrue("Euro error",price.contains("€"));
        logger.info("Euro switched success");

    }

    @After
    public void close_browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
