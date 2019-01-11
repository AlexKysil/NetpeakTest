package lib;

import helpClasses.registrationUser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BaseCommands {

        BaseCommands bc = new BaseCommands();

    public void navigateToRegistratioPage(){
        bc.OpenNetpeakWebSite();
        bc.driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/signup']")).click();
    }

    public void FillInRegistrationFormAndSubmit(registrationUser user){
        bc.driver.findElement(By.xpath("//input[@id='fos_user_registration_form_firstName']")).sendKeys(user.getFirstName());
        bc.driver.findElement(By.xpath("//input[@id='fos_user_registration_form_lastName']")).sendKeys(user.getLastName());
        bc.driver.findElement(By.xpath("//input[@type='email']")).sendKeys(user.getEmail());
        bc.driver.findElement(By.xpath("//input[@type='password']")).sendKeys(user.getPass());
        if(user.isCheckboxesIsSelected()) {
            bc.driver.findElement(By.xpath("//input[@type='checkbox' and @id='fos_user_registration_form_termsOfUse']")).click();
            bc.driver.findElement(By.xpath("//input[@type='checkbox' and @id='fos_user_registration_form_privacyPolicy']")).click();
        }
        bc.driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public String getErrorMSGforInvalidCredentials(){
        bc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger text-center']")));
        String msg = bc.driver.findElement(By.xpath("//div[@class='alert alert-danger text-center']")).getText();
        return msg;
    }

}
