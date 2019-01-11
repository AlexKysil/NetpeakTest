package lib;

import org.openqa.selenium.By;

public class RegistrationPage extends BaseCommands {

        BaseCommands bc = new BaseCommands();

    public void navigateToRegistratioPage(){
        bc.OpenNetpeakWebSite();
        bc.driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/signup']")).click();
    }

}
