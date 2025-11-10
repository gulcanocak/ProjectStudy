package Testinium.TestCases;
import Testinium.Base.BaseTest;
import Testinium.Pages.SelectProduct;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectProductTest extends BaseTest {

    @Test(priority = 1)
    public void OpenMenu() throws IOException, InterruptedException {
        SelectProduct selectProductPage = new SelectProduct(driver);
        selectProductPage.OpenMenu();
        log.info("Menu Opened");
        selectProductPage.SearchProduct();
        log.info("Product Searched.");
        selectProductPage.selectRandomProduct();
        log.info("Random Product selected.");

    }
}
