package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class StartFinishFixture {

        public static WebDriver driver;
        public static WebDriverWait wait;

        @BeforeClass
        public void startFixture() {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 15);
        }

        @AfterClass
        public void finishFixture(){
            driver.quit();
        }
    }

