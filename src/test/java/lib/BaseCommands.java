package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseCommands {

    public static WebDriver driver;
    public static WebDriverWait wait;
    static String URl= "https://netpeaksoftware.com/";

    public void init() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
    }

    public void stop() {
        driver.quit();
    }

    public static void OpenNetpeakWebSite(){
        driver.navigate().to(URl);
    }
}
