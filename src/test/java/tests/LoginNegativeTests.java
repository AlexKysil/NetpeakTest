package tests;

import helpClasses.logInUser;
import lib.LogInPage;
import lib.StartFinishFixture;
import org.testng.annotations.Test;

public class LoginNegativeTests extends StartFinishFixture {
    LogInPage lp = new LogInPage();
    logInUser user = new logInUser("admin", "admin");

    @Test
    public void NegativeLoginCase(){
        lp.NavigateToLogInPage();
        lp.FillInLoginFormAndSubmit(user);
        assert (lp.getExpectedError().equals(lp.getErrorMSGforInvalidCredentials()));
    }
}
