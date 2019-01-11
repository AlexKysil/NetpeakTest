package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class StartFinishFixture {
    BaseCommands bc = new BaseCommands();

        @BeforeClass
        public void setUp() {
            bc.init();
        }

    @AfterClass
        public void tearDown(){
        bc.stop();
    }

}

