import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class AgencyTest {

    private Agency agency;

    @BeforeEach
    void setUp() {
        agency = new Agency();
    }

    /**
     * It is true if employee is added successfully
     */
    @Test
    void addEmployee() {
        Employee employee = new Employee("Test Employee");
        agency.addEmployee(employee);
        assertTrue(agency.getEmployeesList().contains(employee));
    }

    /**
     * It is true if contract is added successfully
     */
    @Test
    void addContract() {
        Contract contract = new Contract(1000, 5);
        agency.addContract(contract);
        assertTrue(agency.getContractsList().contains(contract));
    }


    /**
     * It should get an employee with the least
     * number of contracts
     */
    @Test
    void getEmployeeWithLeastNumberOfContracts() {
        Employee employee = new Employee("Test Employee");
        Employee employee2 = new Employee("Test Employee");
        agency.addEmployee(employee);
        agency.addEmployee(employee2);
        employee.increaseNumberOfContracts();
        assertEquals(employee2, agency.getEmployeeWithLeastNumberOfContracts());
    }

    /**
     * It should get an employee with the least
     * number of contracts which is last on the list
     * Both employees have 0 contracts
     */
    @Test
    void getEmployeeWithLeastNumberOfContractsIfBothHaveSameNumberOfContracts() {
        Employee employee = new Employee("Test Employee");
        Employee employee2 = new Employee("Test Employee2");
        agency.addEmployee(employee);
        agency.addEmployee(employee2);
        assertEquals(employee, agency.getEmployeeWithLeastNumberOfContracts());
    }

    /**
     * It should get an employee with the least
     * number of contracts which is last on the list
     * Both employees have 0 contracts
     */
    @Test
    void getEmployeeWithLeastNumberOfContractsIfListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            agency.getEmployeeWithLeastNumberOfContracts();
        });
    }

    @Test
    void getSumOfContractsCosts() {
        Contract contract = new Contract(1000, 5);
        Contract contract2 = new Contract(2000, 6);
        agency.addContract(contract);
        agency.addContract(contract2);
        assertEquals(3000, agency.getSumOfContractsCosts());
    }
}