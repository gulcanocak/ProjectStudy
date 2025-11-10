package Testinium.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CardDetail extends HomePage {
    public CardDetail(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-qa-id='layout-header-go-to-cart']")
    WebElement cartButton;

    @FindBy(xpath = "//span[@class='money-amount__main']")
    WebElement productPrice;
    @FindBy(xpath = "//input[@class='zds-quantity-selector__units shop-cart-item-quantity']")
    WebElement quantity;
    @FindBy(xpath = "//div[@class='zds-quantity-selector__increase']")
    WebElement increaseQuantity;
    @FindBy(xpath = "//button[@aria-label='Ürünü sil']")
    WebElement removeProduct;
    @FindBy(xpath = "//div[@class='zds-quantity-selector__decreasE']")
    WebElement decreaseProduct;

    @FindBy(xpath = "/span[contains(text(),'SEPETİNİZ BOŞ')]")
    WebElement emptyCart;


    public String priceInCart() throws InterruptedException {
        Thread.sleep(3000);
            driver.navigate().to("https://www.zara.com/tr/tr/shop/cart");


        waitUntilElementIsVisible(productPrice);
        waitUntilClickable(productPrice);
        String Price = productPrice.getText();
        return Price;
    }

    public String numberOfProductsInCart() {
        waitUntilElementIsVisible(quantity);
        waitUntilElementIsVisible(quantity);
        String quantityValue = quantity.getAttribute("value");
        return quantityValue;
    }

    public void increaseQuantityInCart() throws InterruptedException {
        waitUntilElementIsVisible(increaseQuantity);
        waitUntilClickable(increaseQuantity);
        increaseQuantity.click();
        Thread.sleep(2000);
    }

    public void empty() throws InterruptedException {
        waitUntilElementIsVisible(removeProduct);
        waitUntilClickable(removeProduct);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", removeProduct);
        Thread.sleep(500);
        removeProduct.click();

    }
    public String cartText(){
        waitUntilElementIsVisible(emptyCart);
        return emptyCart.getText();
    }
}
