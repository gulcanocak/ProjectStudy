package Testinium.Pages;

import Testinium.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ProductDetails extends HomePage {
    WebDriver driver;

    public ProductDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='product-detail-description product-detail-info__description']")
    WebElement productDescription;

    @FindBy(xpath = "//span[@class='money-amount__main']")
    WebElement productPrice;

    @FindBy(xpath = "//button[@data-qa-action='add-to-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "(//button[@class='size-selector-sizes-size__button'])[1]")
    WebElement selectSize;

    @FindBy(xpath = "//button[@data-qa-id='zds-alert-dialog-cancel-button']")
    WebElement cancelButton;


    public void writeToDocument(String Detail, String Price) throws IOException {

        File file = new File("/Users/gulcanocak/Documents/workspace-spring-tool-suite-4-4.5.1.RELEASE/ZaraTestProject/src/test/java/Utilies/file.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(Detail);
        pw.println(Price);
        pw.close();
    }

    public String getProductDetails() throws IOException {
        waitUntilClickable(productDescription);
        String Detail = productDescription.getText();
        String Price = productPrice.getText();
        waitUntilClickable(productPrice);
        ProductDetails productDetails = new ProductDetails(driver);
        productDetails.writeToDocument(Detail, Price);
        System.out.println("Product details written to: " + Detail + "Price: " + Price);
        return Price;

    }

    public void selectSize() {
        waitUntilElementIsVisible(addToCartButton);
        waitUntilClickable(addToCartButton);
        addToCartButton.click();
    }

    public void clickAddCart() {
        waitUntilElementIsVisible(selectSize);
        waitUntilClickable(selectSize);
        selectSize.click();
    }

    public void clickCancelButton() throws InterruptedException {

        Thread.sleep(1000);


        if (cancelButton.isDisplayed() && cancelButton.isEnabled()) {

            waitUntilElementIsVisible(cancelButton);
            waitUntilClickable(cancelButton);
            cancelButton.click();
            System.out.println("The Cancel button was clicked and the window was closed.");
        } else {
            System.out.println("Cancel button not visible, continuing...");

        }
    }
}
