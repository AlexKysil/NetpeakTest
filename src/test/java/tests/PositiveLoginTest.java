package tests;

import helpClasses.logInUser;
import lib.LogInPage;
import lib.StartFinishFixture;
import org.testng.annotations.Test;

public class PositiveLoginTest extends StartFinishFixture {
    LogInPage lp = new LogInPage();
    logInUser user = new logInUser("netpeaksoftwaretest@gmail.com", "123456");

    @Test
    public void openBrowserTest(){
        lp.NavigateToLogInPage();
        lp.FillInLoginFormAndSubmit(user);
        assert(lp.getExpectedLoggedInPageTitle().equals(lp.getActualPageTitle()));
    }
}
