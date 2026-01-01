public class AdmissionOfficer {
    String username;
    String password;
    public AdmissionOfficer(){
        username = "abid";
        password = "abid";
    }


    public boolean authenticate(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}
