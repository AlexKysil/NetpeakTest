package tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import helpClasses.logInUser;
import lib.LogInPage;
import lib.StartFinishFixture;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class PositiveLoginTest extends StartFinishFixture {
    LogInPage lp = new LogInPage();

    @DataProvider
    public Iterator<Object[]> validDataForLogin() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/data/positive_login_data.json")));
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

    @Test (dataProvider = "validDataForLogin")
    public void openBrowserTest(logInUser user){
        lp.NavigateToLogInPage();
        lp.FillInLoginFormAndSubmit(user);
        assert(lp.getExpectedLoggedInPageTitle().equals(lp.getActualPageTitle()));
    }
}
