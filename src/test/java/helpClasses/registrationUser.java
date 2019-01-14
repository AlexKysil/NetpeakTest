package helpClasses;

public class registrationUser {
    String firstName;
    String lastName;
    String email;
    String password;
    boolean checkboxesIsSelected;

    public registrationUser(String firstName, String lastName, String email, String password, String checkboxesIsSelected){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        if(checkboxesIsSelected.equals("true")){
            this.checkboxesIsSelected = true;
        }else if(checkboxesIsSelected.equals("false"))
        {
            this.checkboxesIsSelected = false;
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = password;
    }

    public boolean isCheckboxesIsSelected() {
        return checkboxesIsSelected;
    }

    public void setCheckboxesIsSelected(boolean checkboxesIsSelected) {
        this.checkboxesIsSelected = checkboxesIsSelected;
    }
}
