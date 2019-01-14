package helpClasses;

public class logInUser {
    String email;
    String password;

    public logInUser(String email, String password){
        this.email = email;
        this.password = password;
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

    public void setPass(String password) {
        this.password = password;
    }

}
