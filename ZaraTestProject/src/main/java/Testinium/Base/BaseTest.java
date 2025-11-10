package Testinium.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class BaseTest {
   public static WebDriver driver;
    public static Logger log=LogManager.getLogManager().getLogger("");



    @BeforeSuite
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/java/Utilies/chromedriver");
        driver = new ChromeDriver();
        log.info("Chrome driver loaded");
        driver.get("https://zara.com/tr/");
        log.info("Navigated to Zara");
        driver.manage().window().maximize();
        String Title= driver.getTitle();
        //7Assert.assertEquals("Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu",Title);
        log.info("Zara is opened");

    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();

    }

}
