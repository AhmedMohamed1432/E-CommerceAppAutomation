package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.*;

public class CompeletScenarioStepDefinition {
        WebDriver driver;
        ShoppingCartPage shoppingCart;
        BillingPage billingPage;
        ShippingPage shippingPage;
        ShippingAddress shippingAddress;
        PaymentMethodPage paymentMethodPage;
        PaymentInfoPage paymentInfoPage;
        ConfirmOrderPage confirmOrderPage;
        CompletedPage completedPage;
        Logger logger;

        @Given("user go to shopping cart page")
        public void shoppingCartPage(){
            driver = hooks.getDriver();
            driver.get("https://demo.nopcommerce.com/cart");
        }

        @When("user check terms of service checkbox")
        public void checkTermsServiceCheckbox(){
            shoppingCart = new ShoppingCartPage(driver);
            shoppingCart.checkTermsofservice().click();
        }

        @And("user press checkout button")
        public void clickCheckoutButton(){
            shoppingCart.checkoutButton().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Then("user go to billing page")
        public void billingPage(){
            logger = LoggerFactory.getLogger(CompeletScenarioStepDefinition.class);
            logger.info("Billing Page Result:");
            String expurl = "https://demo.nopcommerce.com/onepagecheckout#opc-billing";

            Assert.assertEquals("Billing page Error!",
                    expurl,driver.getCurrentUrl());
            if(driver.getCurrentUrl().equals(expurl)){
                logger.info("Pass");
            }else logger.error("Fail");
        }

        @When("user fill data")
        public void user_fill_Data(){
            billingPage = new BillingPage(driver);
            try {
                WebElement addressList = driver.findElement(
                        By.cssSelector("select[id=\"billing-address-select\"]"));
                if(addressList.isDisplayed()) {
                    org.openqa.selenium.support.ui.Select billingAddress = new org.openqa.selenium.support.ui.Select(addressList);
                    billingAddress.selectByVisibleText("New Address");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            billingPage.firstName().clear();
            billingPage.firstName().sendKeys("Ahmed");
            billingPage.lastName().clear();
            billingPage.lastName().sendKeys("Fouad");
            billingPage.email().clear();
            billingPage.email().sendKeys("Ahmed9@gmail.com");
            org.openqa.selenium.support.ui.Select countryList = new Select(billingPage.country());
            countryList.selectByVisibleText("Egypt");
            billingPage.city().sendKeys("Cairo");
            billingPage.address().sendKeys("October");
            billingPage.postalCode().sendKeys("20020");
            billingPage.phone().sendKeys("011111111");

            WebElement shipAddress = billingPage.shipSameAddress();
            if(!shipAddress.isSelected()){
                shipAddress.click();
            }
        }
        @And("user click continue button")
        public void click_continue_button_FD(){
            billingPage.continueButton().click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Then("user go to shipping page")
        public void go_shipping_page(){
            logger = LoggerFactory.getLogger(CompeletScenarioStepDefinition.class);
            logger.info("Shipping Page Result:");
            String expectedURLShippingAdd = "https://demo.nopcommerce.com/onepagecheckout#opc-shipping";
            String expectedUrlShippingMethod = "https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method";

            if(driver.getCurrentUrl().equals(expectedURLShippingAdd)){
                logger = LoggerFactory.getLogger(CompeletScenarioStepDefinition.class);
                logger.info("Shipping Address Page Result:");

                Assert.assertEquals("Shipping Page Error!", expectedURLShippingAdd,
                        driver.getCurrentUrl());
                if(driver.getCurrentUrl().equals(expectedURLShippingAdd)){
                    logger.info("Pass");
                }else logger.error("Fail");

                shippingAddress = new ShippingAddress(driver);

                shippingAddress.continueButton().click();

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            Assert.assertEquals("shipping page error", expectedUrlShippingMethod,
                    driver.getCurrentUrl());

            if (driver.getCurrentUrl().equals(expectedUrlShippingMethod)) {
                logger.info("Pass");
            } else logger.error("Fail");

        }

        @When("press continue button in shipping page")
        public void press_continue_button_Shipping(){
            shippingPage = new ShippingPage(driver);
            shippingPage.continueButton().click();
        }

        @Then("user go to payment method page")
        public void go_paymentMethod_page(){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger = LoggerFactory.getLogger(CompeletScenarioStepDefinition.class);
            logger.info("Payment Method Page Result:");

            String expectedUrl = "https://demo.nopcommerce.com/onepagecheckout#opc-payment_method";
            Assert.assertEquals("payment method page Error!", expectedUrl,
                    driver.getCurrentUrl());
            if(driver.getCurrentUrl().equals(expectedUrl)){
                logger.info("Pass");
            }else logger.error("Fail");
        }

        @When("user click continue button in payment method")
        public void click_continue_button_PM(){
            paymentMethodPage = new PaymentMethodPage(driver);
            paymentMethodPage.continueButton().click();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        @Then("user go to payment information page")
        public void go_paymentInformation(){
            logger = LoggerFactory.getLogger(CompeletScenarioStepDefinition.class);
            logger.info("Payment information Page Result:");

            String expectedUrl = "https://demo.nopcommerce.com/onepagecheckout#opc-payment_info";
            Assert.assertEquals("payment information page Error!", expectedUrl,
                    driver.getCurrentUrl());

            if(driver.getCurrentUrl().equals(expectedUrl)){
                logger.info("Pass");
            }else logger.error("Fail");
        }

        @When("user click continue button in payment information")
        public void click_continue_button_PI(){
            paymentInfoPage = new PaymentInfoPage(driver);
            paymentInfoPage.continueButton().click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Then("user go to confirm order page")
        public void go_confirmOrder(){
            logger = LoggerFactory.getLogger(CompeletScenarioStepDefinition.class);
            logger.info("Confirm Order Page Result:");

            String expectedUrl = "https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order";
            Assert.assertEquals("confirm order page error", expectedUrl,
                    driver.getCurrentUrl());

            if(driver.getCurrentUrl().equals(expectedUrl)){
                logger.info("Pass");
            }else logger.error("Fail");
        }

        @When("user click on confirm button in confirm order")
        public void click_confirm_button_CO(){
            confirmOrderPage = new ConfirmOrderPage(driver);
            confirmOrderPage.continueButton().click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Then("user see complete successful order")
        public void complete_successful_order(){
            logger = LoggerFactory.getLogger(CompeletScenarioStepDefinition.class);
            logger.info("Complete Order Page Result:");

            String expectedUrl = "https://demo.nopcommerce.com/checkout/completed";
            Assert.assertEquals("complete successful page error", expectedUrl,
                    driver.getCurrentUrl());

            if(driver.getCurrentUrl().equals(expectedUrl)){
                logger.info("Pass");
            }else logger.error("Fail");
        }

        @When("user click continue button in complete successful order")
        public void click_continue_button_CS() {
            completedPage = new CompletedPage(driver);
            completedPage.continueButton().click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        @Then("user go to home page again")
        public void go_home_success(){
            logger = LoggerFactory.getLogger(CompeletScenarioStepDefinition.class);
            logger.info("Complete scenario Result:");
            Assert.assertEquals("https://demo.nopcommerce.com/",
                    driver.getCurrentUrl());
            if(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/"))
                logger.info("Pass");
            else logger.error("Fail");

        }


}
