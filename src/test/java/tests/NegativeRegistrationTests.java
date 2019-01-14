package tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import helpClasses.logInUser;
import helpClasses.registrationUser;
import lib.RegistrationPage;
import lib.StartFinishFixture;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class NegativeRegistrationTests extends StartFinishFixture {
    RegistrationPage rp = new RegistrationPage();

    @DataProvider
    public Iterator<Object[]> invalidDataForRegistration() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/data/negative_registration_data.json")));
        String json = "";
        String line = reader.readLine();
        while(line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<registrationUser> users = gson.fromJson(json, new TypeToken<List<registrationUser>>(){}.getType());
        return users.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "invalidDataForRegistration")
    public void registrationNagativeCases(registrationUser user){
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
