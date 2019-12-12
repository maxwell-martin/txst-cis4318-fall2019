import java.io.Serializable;

public class Employee implements Serializable {
    private String firstName;
    private String lastName;
    private int monthlySalary;
    private int monthsOfPayment;
    private double yearlySalary;

    // No argument constructor
    public Employee() {
    }

    // Parameterized constructor
    public Employee(String firstName, String lastName, int monthlySalary, int monthsOfPayment, double yearlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.monthlySalary = monthlySalary;
        this.monthsOfPayment = monthsOfPayment;
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

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getMonthsOfPayment() {
        return monthsOfPayment;
    }

    public void setMonthsOfPayment(int monthsOfPayment) {
        this.monthsOfPayment = monthsOfPayment;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public static double calculateYearlySalary(int monthlySalary, int monthsOfPayment) {
        return monthlySalary * monthsOfPayment;
    }
}
