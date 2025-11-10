package Testinium.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement cookieAccept;
    @FindBy(xpath = "//a[text()='GİRİŞ YAP']")
    WebElement login;
    @FindBy(id="zds-:r5:")
    WebElement eMail;
    @FindBy(id = "zds-:r8:")
    WebElement passwordField;
    @FindBy(xpath="//button[normalize-space()='Oturum aç']")
    WebElement loginButton;

    public void waitUntilElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void closePopUp() {
        waitUntilElementIsVisible(cookieAccept);
        waitUntilClickable(cookieAccept);
        cookieAccept.click();
    }
    public void clickLoginButton(){
        waitUntilElementIsVisible(login);
        waitUntilClickable(login);
        login.click();
    }
    public void Login(String email, String password) {
        waitUntilElementIsVisible(eMail);
        waitUntilClickable(eMail);
        eMail.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();

    }


}