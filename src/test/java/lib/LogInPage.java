package lib;

import helpClasses.logInUser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LogInPage extends BaseCommands {
    public BaseCommands bc = new BaseCommands();
    String expectedError = "Invalid credentials.";
    String expectedLoggedInPageTitle = "Панель управления – Netpeak Software";

    public void NavigateToLogInPage(){
        bc.OpenNetpeakWebSite();
        bc.driver.findElement(By.xpath("//a[@href='/login']")).click();
    }

    public void FillInLoginFormAndSubmit(logInUser user){
        bc.driver.findElement(By.xpath("//input[@name='_username']")).clear();
        bc.driver.findElement(By.xpath("//input[@name='_username']")).sendKeys(user.getEmail());
        bc.driver.findElement(By.xpath("//input[@name='_password']")).clear();
        bc.driver.findElement(By.xpath("//input[@name='_password']")).sendKeys(user.getPass());
        bc.driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public String getErrorMSGforInvalidCredentials(){
        bc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger text-center']")));
         String msg = bc.driver.findElement(By.xpath("//div[@class='alert alert-danger text-center']")).getText();
         return msg;
    }
    public String getExpectedError() {
        return expectedError;
    }

    public String getExpectedLoggedInPageTitle() {
        return expectedLoggedInPageTitle;
    }
    public String getActualPageTitle(){
        waitForElementInPageLoaded("//h1[contains(text(),'Панель управления')]");
        return bc.getPageTitle();
    }

}
