package Testinium.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class SelectProduct extends HomePage {

    WebDriver driver;

    String xx;

    public SelectProduct(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    @FindBy(xpath = "//button[@aria-label='Menüyü aç']//*[name()='svg']")
    WebElement menuButton;

    @FindBy(xpath = "//span[@class='layout-categories-category-name' and text()='ERKEK']")
    WebElement manMenu;

    @FindBy(xpath = "//span[normalize-space()='TÜMÜNÜ GÖR']")
    WebElement selectAll;


    @FindBy(xpath = "//span[@class='layout-header-action-search__content']")
    WebElement searchField;

    @FindBy(id = "search-home-form-combo-input")
    WebElement searchField2;

    @FindBy(xpath = "(//li[@class='product-grid-product _product product-grid-product--is-not-template product-grid-product--ZOOM2-columns product-grid-product--0th-column'])")
    WebElement productItems;

    public void OpenMenu() {
        waitUntilElementIsVisible(menuButton);
        waitUntilClickable(menuButton);
        menuButton.click();
        waitUntilElementIsVisible(manMenu);
        waitUntilClickable(manMenu);
        manMenu.click();
        waitUntilClickable(selectAll);
        selectAll.click();

    }

    public void SearchProduct() throws IOException, InterruptedException {
        waitUntilElementIsVisible(searchField);
        waitUntilClickable(searchField);
        dataReadFromXlsx dt = new dataReadFromXlsx();
        String searchedText = dt.readData(0, 0);
        searchField.click();
        waitUntilElementIsVisible(searchField2);
        searchField2.sendKeys(searchedText);
        Thread.sleep(2000);
        searchField2.sendKeys(Keys.COMMAND + "a");
        searchField2.sendKeys(Keys.DELETE);
        String searchedText2 = dt.readData(0, 1);
        searchField2.sendKeys(searchedText2);
        searchField2.sendKeys(Keys.ENTER);
    }

    public void selectRandomProduct() {


        waitUntilClickable(productItems);
        List<WebElement> productElements = driver.findElements(By.xpath("(//li[@class='product-grid-product _product product-grid-product--is-not-template product-grid-product--ZOOM2-columns product-grid-product--0th-column'])"));

        List<WebElement> products = driver.findElements(By.xpath("//li[contains(@class, 'product-grid-product')]"));
        System.out.println("Total Product: " + products.size());

        if (products.isEmpty()) {
            System.out.println("No product found!");

        }
        Random random = new Random();
        int randomIndex = random.nextInt(products.size());
        WebElement randomProduct = products.get(randomIndex);


        System.out.println("Selected Product Index: " + randomIndex);
        xx = randomProduct.findElement(By.xpath(".//span[@class='money-amount__main']")).getText();
        Actions actions = new Actions(driver);
        actions.moveToElement(randomProduct).click().perform();


    }

}


