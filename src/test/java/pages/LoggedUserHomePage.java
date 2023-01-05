package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedUserHomePage {

    WebDriver driver;

    public LoggedUserHomePage(WebDriver driver){
        this.driver = driver;
    }

    //Search SC4
    public WebElement searchItems(){
        By searchTerms = By.id("small-searchterms");
        return driver.findElement(searchTerms);
    }
    //Currency SC5
    public WebElement CurrencyOption(){
        By customerCurrency = By.id("customerCurrency");
        return driver.findElement(customerCurrency);
    }
    public WebElement changeCurrency(){
        By changeCurrency = By.cssSelector("div[data-productid=\"4\"]>div>div>div[class=\"prices\"]>span");
        return driver.findElement(changeCurrency);
    }
    //Select category SC6
    public WebElement categoryList(){
        By categoryList = By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href=\"/computers\"]"); // main list is "div> ul[class="top-menu notmobile"]"
        return driver.findElement(categoryList);
    }

    public WebElement subCategory(){
        By subCategory = By.cssSelector("ul[class=\"top-menu notmobile\"]>li>ul[class=\"sublist first-level\"]>li>a[href=\"/notebooks\"]");
        return driver.findElement(subCategory);
    }
    //Add product to cart SC9
    public WebElement addToCart(){
        By addToCard = By.cssSelector("div[data-productid=\"4\"]>div>div>div[class=\"buttons\"]>button[class=\"button-2 product-box-add-to-cart-button\"]");
        return driver.findElement(addToCard);
    }

    public WebElement addToCartButton(){
        By addToCard = By.id("add-to-cart-button-4");
        return driver.findElement(addToCard);
    }

    public WebElement addToCartSuccess(){
        By addToCardSuccess = By.cssSelector("div[class=\"bar-notification success\"]>p[class=\"content\"]");
        return driver.findElement(addToCardSuccess);
    }
    public WebElement cartLink(){
        By cartLink = By.cssSelector("div>p>a[href=\"/cart\"]");
        return driver.findElement(cartLink);
    }
    //Add to wishlist SC10
    public WebElement addToWishlist(){
        By addToWishlist = By.cssSelector("div[data-productid=\"4\"]>div>div>div[class=\"buttons\"]>button[class=\"button-2 add-to-wishlist-button\"]");
        return driver.findElement(addToWishlist);
    }

    public WebElement addToWishlistButton(){
        By addToCard = By.id("add-to-wishlist-button-4");
        return driver.findElement(addToCard);
    }

    public WebElement addToWishlistSuccess(){
        By addToCardSuccess = By.cssSelector("div>p[class=\"content\"]");
        return driver.findElement(addToCardSuccess);
    }

    public WebElement wishLink(){
        By wishLink = By.cssSelector("div>p>a[href=\"/wishlist\"]");
        return driver.findElement(wishLink);
    }
    //Add to CompareList SC11
    public WebElement addToCompareList(){
        By addToWishlist = By.cssSelector("div[data-productid=\"4\"]>div>div>div[class=\"buttons\"]>button[class=\"button-2 add-to-compare-list-button\"]");
        return driver.findElement(addToWishlist);
    }

    public WebElement addToCompareListSuccess(){
        By addToCompareListSuccess = By.cssSelector("div>p[class=\"content\"]");
        return driver.findElement(addToCompareListSuccess);
    }

    public WebElement compareLink(){
        By compLink = By.cssSelector("div>p>a[href=\"/compareproducts\"]");
        return driver.findElement(compLink);
    }
}
