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
        By tagpath = By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/ul/li[1]/a");
        return driver.findElement(tagpath);
    }
}
