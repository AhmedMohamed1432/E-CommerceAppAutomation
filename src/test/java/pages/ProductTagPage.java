package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepDefinitions.hooks;

public class ProductTagPage {
    WebDriver driver;

    public ProductTagPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement tags()
    {
        By taglink = By.cssSelector("a[href=\"/apparel-2\"]");
        return driver.findElement(taglink);
    }
}
