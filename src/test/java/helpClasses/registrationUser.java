package helpClasses;

public class registrationUser {
    String firstName;
    String lastName;
    String email;
    String pass;
    boolean checkboxesIsSelected;

    public registrationUser(String firstName, String lastName, String email, String pass, boolean checkboxesIsSelected){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.checkboxesIsSelected = checkboxesIsSelected;
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
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isCheckboxesIsSelected() {
        return checkboxesIsSelected;
    }

    public void setCheckboxesIsSelected(boolean checkboxesIsSelected) {
        this.checkboxesIsSelected = checkboxesIsSelected;
    }
}
