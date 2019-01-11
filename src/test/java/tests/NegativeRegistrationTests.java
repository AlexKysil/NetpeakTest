package tests;

import lib.RegistrationPage;
import lib.StartFinishFixture;
import org.testng.annotations.Test;

public class NegativeRegistrationTests extends StartFinishFixture {
    RegistrationPage rp = new RegistrationPage();

    @Test
    public void openBrowserTest(){
        rp.navigateToRegistratioPage();
    }
}
