package Testinium.TestCases;

import Testinium.Pages.HomePage;
import org.testng.annotations.Test;
import Testinium.Base.BaseTest;

public class HomePageTest extends BaseTest {


    @Test(priority = 1)
    public void closePopUp() {
        HomePage homePage = new HomePage(driver);
        homePage.closePopUp();
    }

    @Test(priority = 2)
    public void Login() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.Login("gulcanocakk@gmail.com", "Testinium123.");

    }
}
