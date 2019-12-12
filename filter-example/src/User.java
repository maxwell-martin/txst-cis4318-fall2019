import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String userEmail;

    public User() {
        userName = "";
        userEmail = "";
    }

    public User(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // Must override equals method to use contains method of ArrayList of User objects.
    @Override
    public boolean equals(Object obj) {
        User myUser = (User) obj;
        if (userName.equals(myUser.getUserName()) && userEmail.equals(myUser.getUserEmail())) {
            return true;
        }
        else {
            return false;
        }
    }
}
