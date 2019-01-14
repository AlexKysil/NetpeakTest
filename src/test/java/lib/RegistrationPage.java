package lib;

import helpClasses.registrationUser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BaseCommands {

        BaseCommands bc = new BaseCommands();
        String ExpectedErrorForInvalidFirstName = "Please specify your first name";
        String ExpectedErrorForInvalidLastName = "Please specify your last name";
        String ExpectedErrorForInvalidEmail = "Please enter an email";
        String ExpectedErrorForInvalidPass = "Please enter a password";
        String ExpectedErrorForUnselectedCheckboxeTerms = "In order to use our products and website you must agree to Terms of Use";
        String ExpectedErrorForUnselectedCheckboxePrivacy = "In order to use our products and website you must agree to Privacy Policy";

    public void navigateToRegistratioPage(){
        bc.OpenNetpeakWebSite();
        bc.driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/signup']")).click();
    }

    public void FillInRegistrationFormAndSubmit(registrationUser user){
        bc.driver.findElement(By.xpath("//input[@id='fos_user_registration_form_firstName']")).clear();
        bc.driver.findElement(By.xpath("//input[@id='fos_user_registration_form_firstName']")).sendKeys(user.getFirstName());
        bc.driver.findElement(By.xpath("//input[@id='fos_user_registration_form_lastName']")).clear();
        bc.driver.findElement(By.xpath("//input[@id='fos_user_registration_form_lastName']")).sendKeys(user.getLastName());
        bc.driver.findElement(By.xpath("//input[@type='email']")).clear();
        bc.driver.findElement(By.xpath("//input[@type='email']")).sendKeys(user.getEmail());
        bc.driver.findElement(By.xpath("//input[@type='password']")).clear();
        bc.driver.findElement(By.xpath("//input[@type='password']")).sendKeys(user.getPass());
        if(user.isCheckboxesIsSelected()) {
            bc.driver.findElement(By.xpath("//input[@type='checkbox' and @id='fos_user_registration_form_termsOfUse']")).click();
            bc.driver.findElement(By.xpath("//input[@type='checkbox' and @id='fos_user_registration_form_privacyPolicy']")).click();
        }
        bc.driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public String getErrorMSGforInvalidFirstName(){
        bc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fos_user_registration_form_firstName']/..//li")));
        String msg = bc.driver.findElement(By.xpath("//input[@id='fos_user_registration_form_firstName']/..//li")).getText();
        return msg;
    }
    public String getErrorMSGforInvalidLastName(){
        bc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fos_user_registration_form_lastName']/..//li")));
        String msg = bc.driver.findElement(By.xpath("//input[@id='fos_user_registration_form_lastName']/..//li")).getText();
        return msg;
    }
    public String getErrorMSGforInvalidEmail(){
        bc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']/..//li")));
        String msg = bc.driver.findElement(By.xpath("//input[@type='email']/..//li")).getText();
        return msg;
    }
    public String getErrorMSGforInvalidPass(){
        bc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']/..//li")));
        String msg = bc.driver.findElement(By.xpath("//input[@type='password']/..//li")).getText();
        return msg;
    }
    public String getErrorMSGforNotSelectedTermsCheckboxe(){
        bc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox' and @id='fos_user_registration_form_termsOfUse']/../../..//li")));
        String msg = bc.driver.findElement(By.xpath("//input[@type='checkbox' and @id='fos_user_registration_form_termsOfUse']/../../..//li")).getText();
        return msg;
    }
    public String getErrorMSGforNotSelectedPrivacyCheckboxe(){
        bc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox' and @id='fos_user_registration_form_privacyPolicy']/../../..//li")));
        String msg = bc.driver.findElement(By.xpath("//input[@type='checkbox' and @id='fos_user_registration_form_privacyPolicy']/../../..//li")).getText();
        return msg;
    }

    public String getExpectedErrorForInvalidFirstName() {
        return ExpectedErrorForInvalidFirstName;
    }
    public String getExpectedErrorForInvalidLastName() {
        return ExpectedErrorForInvalidLastName;
    }
    public String getExpectedErrorForInvalidEmail() {
        return ExpectedErrorForInvalidEmail;
    }
    public String getExpectedErrorForInvalidPass() {
        return ExpectedErrorForInvalidPass;
    }
    public String getExpectedErrorForUnselectedCheckboxeTerms() {
        return ExpectedErrorForUnselectedCheckboxeTerms;
    }
    public String getExpectedErrorForUnselectedCheckboxePrivacy() {
        return ExpectedErrorForUnselectedCheckboxePrivacy;
    }



}
