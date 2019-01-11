package tests;

import helpClasses.registrationUser;
import lib.RegistrationPage;
import lib.StartFinishFixture;
import org.testng.annotations.Test;

public class NegativeRegistrationTests extends StartFinishFixture {
    RegistrationPage rp = new RegistrationPage();
    registrationUser user = new registrationUser("", "", "","", false);

    @Test
    public void registrationNagativeCases(){
        rp.navigateToRegistratioPage();
        rp.FillInRegistrationFormAndSubmit(user);
        if(user.getFirstName().isEmpty()){
            assert(rp.getExpectedErrorForInvalidFirstName().equals(rp.getErrorMSGforInvalidFirstName()));
        }
        if(user.getLastName().isEmpty()){
            assert(rp.getExpectedErrorForInvalidLastName().equals(rp.getErrorMSGforInvalidLastName()));
        }
        if(user.getEmail().isEmpty()){
            assert(rp.getExpectedErrorForInvalidEmail().equals(rp.getErrorMSGforInvalidEmail()));
        }
        if(user.getPass().isEmpty()){
            assert(rp.getExpectedErrorForInvalidPass().equals(rp.getErrorMSGforInvalidPass()));
        }
        if(user.isCheckboxesIsSelected()==false){
            assert(rp.getExpectedErrorForUnselectedCheckboxeTerms().equals(rp.getErrorMSGforNotSelectedTermsCheckboxe()));
            assert(rp.getExpectedErrorForUnselectedCheckboxePrivacy().equals(rp.getErrorMSGforNotSelectedPrivacyCheckboxe()));
        }
    }
}
