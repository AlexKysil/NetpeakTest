package lib;

import org.openqa.selenium.By;


public class LogInPage extends BaseCommands {
BaseCommands bc = new BaseCommands();

    public void NavigateToLogInPage(){
        bc.OpenNetpeakWebSite();
        bc.driver.findElement(By.xpath("//a[@href='/login']")).click();
    }


}
