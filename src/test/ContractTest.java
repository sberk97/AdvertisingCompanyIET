import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContractTest {

    private Agency agency;
    private Contract contract = new Contract(1000, 1);

    @BeforeEach
    void setUp() {
        agency = new Agency();
    }

    @Test
    void getCost() {
        assertEquals(1000, contract.getCost());
    }

    @Test
    void addDesignerIfLessThanMax() {
        Employee employee = new Employee("Test Employee");
        agency.addEmployee(employee);
        assertTrue(contract.addDesigner(agency));
        assertEquals(1, employee.getNumberOfContracts());
        assertTrue(contract.getDesignersTeam().contains(employee));
    }

    @Test
    void addDesignerIfMoreThanMax() {
        Employee employee = new Employee("Test Employee");
        agency.addEmployee(employee);
        assertTrue(contract.addDesigner(agency));
        assertEquals(1, employee.getNumberOfContracts());
        assertTrue(contract.getDesignersTeam().contains(employee));

        Employee employee2 = new Employee("Test Employee2");
        agency.addEmployee(employee2);
        assertFalse(contract.addDesigner(agency));
        assertEquals(0, employee2.getNumberOfContracts());
        assertFalse(contract.getDesignersTeam().contains(employee2));
    }
}