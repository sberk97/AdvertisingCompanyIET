/**
 * This methods keeps employee's name
 * and number of contracts that employee
 * is working on
 */
public class Employee {

    private String employeeName;
    private int numberOfContracts;

    public Employee(String employeeName) {
        this.employeeName = employeeName;
        this.numberOfContracts = 0;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getNumberOfContracts() {
        return numberOfContracts;
    }

    public void increaseNumberOfContracts() {
        this.numberOfContracts++;
    }
}
