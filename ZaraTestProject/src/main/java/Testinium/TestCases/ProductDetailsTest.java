package Testinium.TestCases;

import Testinium.Base.BaseTest;
import Testinium.Pages.ProductDetails;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductDetailsTest extends BaseTest {

    @Test(priority = 1)
    public void ProductDetails() throws IOException, InterruptedException {
        ProductDetails productDetailsPage = new ProductDetails(driver);
        productDetailsPage.getProductDetails();
        log.info("Product Details got.");
        productDetailsPage.selectSize();
        log.info("Product size selected.");
        productDetailsPage.clickAddCart();
        log.info("Product added to cart.");
        productDetailsPage.clickCancelButton();
    }

}
