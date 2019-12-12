public class TestingClass {
    public static void main(String[] args) {

        // Prints message to screen; shortcut sout
        System.out.println("Hello World!");

        // Create instance of User class
        User u1 = new User("Michael", "Jordan");

        // Use getters and setters to print full name
        System.out.println(u1.getFirstName() + " " + u1.getLastName());

        // Uses getFullName method which uses sout to display full name
        // Void method; does not return anything
        u1.getFullName();

        // Uses getFullName method with parameters and sout to display full name;
        // Value returning method; returns String
        System.out.println(u1.getFullName(u1.getFirstName(), u1.getLastName()));

        // Static method to display a message
        User.welcomeStudent();

        // Another way of creating a User using a static method
        User u2 = User.createUser("Joe", "Smith");
        u2.getFullName();
    }
}
