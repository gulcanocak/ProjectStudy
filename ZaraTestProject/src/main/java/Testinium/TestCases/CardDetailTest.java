package Testinium.TestCases;

import Testinium.Base.BaseTest;
import Testinium.Pages.CardDetail;
import Testinium.Pages.ProductDetails;
import Testinium.Pages.SelectProduct;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CardDetailTest extends BaseTest {

    @Test(priority = 1)
    public void cardDetailPriceTest() throws InterruptedException, IOException {
        CardDetail cd = new CardDetail(driver);
        SelectProduct sp = new SelectProduct(driver);
        ProductDetails pd = new ProductDetails(driver);
        String priceInListedProduct = pd.getProductDetails();
        String priceInCard = cd.priceInCart();
        String firstQuantityProduct = cd.numberOfProductsInCart();
        String increasedQuantityProduct = String.valueOf(Integer.parseInt(firstQuantityProduct) + 1);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        cd.increaseQuantityInCart();
        String newProductQuantity = cd.numberOfProductsInCart();
        Assert.assertEquals(priceInListedProduct, priceInCard);
        log.info("A price comparison test was performed.");

        Assert.assertEquals(newProductQuantity, increasedQuantityProduct);
        log.info("A quantity comparison test was performed.");

        js.executeScript("window.scrollBy(0, -500);");
        Thread.sleep(2000);
        //*************************//
        // Ürün silme iconuna tıklamayı başaramadım maalesef yazmaya çalıştığım kod aşağıdadır.
//        cd.empty();
//        String cartText = cd.cartText();
//        Assert.assertEquals(cartText,"SEPETİNİZ BOŞ");
        // log.info("Cart has been emptied.");

    }
}
