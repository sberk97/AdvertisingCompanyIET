import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ContractTest {

    private Agency agency;
    private Contract contract;

    @BeforeEach
    void setUp() {
        agency = new Agency();
        contract = new Contract(1000, 1);
    }

    /**
     * Checks if constructor throws an exception
     * if cost is negative
     */
    @Test
    void negativeCost() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contract(-1, 1);
        });
    }

    /**
     * Checks if constructor throws an exception
     * if maxNumberOfDesigners is less than 0
     */
    @Test
    void negativeMaxDesigners() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contract(1, -1);
        });
    }

    @Test
    void getCost() {
        assertEquals(1000, contract.getCost());
    }

    /**
     * Methold should add designer as maximum
     * number of designers in a team is 1 and
     * test is adding only one designer
     */
    @Test
    void addDesignerIfLessThanMax() {
        Employee employee = new Employee("Test Employee");
        agency.addEmployee(employee);
        assertTrue(contract.addDesigner(agency));
        assertEquals(1, employee.getNumberOfContracts());
        assertTrue(contract.getDesignersTeam().contains(employee));
    }

    /**
     * Method should only add first designer, as
     * maximumDesignerNumber is set to one
     */
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

    /**
     * Method should throw an exception at the
     * second addDesigner usage as there is only
     * one employee on the list and he is already added
     */
    @Test
    void addDesignerIfItIsAlreadyInATeam() {
        contract = new Contract(1000, 2);
        Employee employee = new Employee("Test Employee");
        agency.addEmployee(employee);
        assertTrue(contract.addDesigner(agency));
        assertEquals(1, employee.getNumberOfContracts());
        assertTrue(contract.getDesignersTeam().contains(employee));

        assertThrows(NoSuchElementException.class, () -> {
            contract.addDesigner(agency);
        });
        assertEquals(1, employee.getNumberOfContracts());
    }
}