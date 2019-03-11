import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class keeps a list of all employees
 * and a list of all contracts of the agency
 */
public class Agency {

    private List<Employee> employeesList;
    private List<Contract> contractsList;

    public Agency() {
        contractsList = new ArrayList<>();
        employeesList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeesList.add(employee);
    }

    public void addContract(Contract contract) {
        contractsList.add(contract);
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public List<Contract> getContractsList() {
        return contractsList;
    }

    /**
     * Solution based on https://www.baeldung.com/java-collection-min-max
     * At first method is coping current list of employees and then
     * removes from that list employees that are currently working in
     * the contract which is calling this method
     * Method is using stream to get all employees objects and then
     * compare value of numberOfContracts from each of them to find
     * the one with the least contracts. If there are more than one
     * employees with same number of contracts, the last one from the list
     * is returned
     * @return Employee object with the least number of contracts, or the last
     * one in the list with this number
     * It can also throw an exception if copiedList is empty
     */
    public Employee getEmployeeWithLeastNumberOfContracts(List<Employee> exceptThem) {
        List<Employee> copiedList = new ArrayList<>(employeesList);
        copiedList.removeAll(exceptThem);
        return copiedList
                .stream()
                .min(Comparator.comparing(Employee::getNumberOfContracts))
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     * Methods iterates through contractsList,
     * gets a value of cost variable from each of them
     * and adds it to total sum
     * @return total sum of costs of all contracts
     */
    public float getSumOfContractsCosts() {
        float sum = 0;
        for(Contract singleContract : contractsList) {
            sum += singleContract.getCost();
        }
        return sum;
    }
}
