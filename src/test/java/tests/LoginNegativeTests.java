package tests;

import lib.LogInPage;
import lib.StartFinishFixture;
import org.testng.annotations.Test;

public class LoginNegativeTests extends StartFinishFixture {
    LogInPage lp = new LogInPage();

    @Test
    public void NegativeLoginCase(){
        lp.NavigateToLogInPage();
    }
}
