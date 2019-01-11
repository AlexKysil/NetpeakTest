package tests;

import helpClasses.registrationUser;
import lib.RegistrationPage;
import lib.StartFinishFixture;
import org.testng.annotations.Test;

public class NegativeRegistrationTests extends StartFinishFixture {
    RegistrationPage rp = new RegistrationPage();
    registrationUser user = new registrationUser("admin", "admin", "valid@gmail.com","123456", false);

    @Test
    public void registrationNagativeCases(){
        rp.navigateToRegistratioPage();
        rp.FillInRegistrationFormAndSubmit(user);
        if(user.getFirstName().isEmpty()){

        }
        if(user.getLastName().isEmpty()){

        }
        if(user.getEmail().isEmpty()){

        }
        if(user.getPass().isEmpty()){

        }
        if(user.isCheckboxesIsSelected()==false){

        }
    }
}
