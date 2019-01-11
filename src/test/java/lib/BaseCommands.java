package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCommands {

    public static WebDriver driver;
    public static WebDriverWait wait;
    static String URl= "https://netpeaksoftware.com/";

    public void init() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
    }

    public void stop() {
        driver.quit();
    }

    public static void OpenNetpeakWebSite(){
        driver.navigate().to(URl);
    }

    public static String getPageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public static void waitForElementInPageLoaded(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

}
