import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee employee = new Employee("Test Employee");

    @Test
    void getEmployeeName() {
        assertEquals("Test Employee", employee.getEmployeeName());
    }

    @Test
    void getNumberOfContracts() {
        assertEquals(0, employee.getNumberOfContracts());
    }

    @Test
    void increaseNumberOfContracts() {
        employee.increaseNumberOfContracts();
        assertEquals(1, employee.getNumberOfContracts());
    }
}