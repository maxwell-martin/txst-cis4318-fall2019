import java.util.ArrayList;

public class User {
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public void getFullName() {
        System.out.println(firstName + " " + lastName);
    }

    public String getFullName(String fn, String ln) {
        return fn + " " + ln;
    }

    public static void welcomeStudent() {
        System.out.println("Welcome student to my class.");
    }

    public static User createUser(String fn, String ln) {
        return new User(fn, ln);
    }
}
