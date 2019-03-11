import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgencyTest {

    private Agency agency = new Agency();

    @Test
    void addEmployee() {
        Employee employee = new Employee("Test Employee");
        agency.addEmployee(employee);
        assertTrue(agency.getEmployeesList().contains(employee));
    }

    @Test
    void addContract() {
        Contract contract = new Contract(1000, 5);
        agency.addContract(contract);
        assertTrue(agency.getContractsList().contains(contract));
    }

    @Test
    void getEmployeeWithLeastNumberOfContracts() {
        Employee employee = new Employee("Test Employee");
        Employee employee2 = new Employee("Test Employee");
        agency.addEmployee(employee);
        agency.addEmployee(employee2);
        employee.increaseNumberOfContracts();
        assertEquals(employee2, agency.getEmployeeWithLeastNumberOfContracts());
    }

    @Test
    void getEmployeeWithLeastNumberOfContractsIfBothHaveSameNumberOfContracts() {
        Employee employee = new Employee("Test Employee");
        Employee employee2 = new Employee("Test Employee2");
        agency.addEmployee(employee);
        agency.addEmployee(employee2);
        assertEquals(employee, agency.getEmployeeWithLeastNumberOfContracts());
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