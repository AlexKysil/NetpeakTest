package tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import helpClasses.logInUser;
import lib.LogInPage;
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

public class LoginNegativeTests extends StartFinishFixture {
    LogInPage lp = new LogInPage();

    @DataProvider
    public Iterator<Object[]> invalidDataForLogin() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/data/negative_login_data.json")));
        String json = "";
        String line = reader.readLine();
        while(line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<logInUser> users = gson.fromJson(json, new TypeToken<List<logInUser>>(){}.getType());
        return users.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "invalidDataForLogin")
    public void NegativeLoginCase(logInUser user){
        lp.NavigateToLogInPage();
        System.out.println("User email: " + user.getEmail() + " User password: " + user.getPass());
        lp.FillInLoginFormAndSubmit(user);
        assert (lp.getExpectedError().equals(lp.getErrorMSGforInvalidCredentials()));
    }
}
