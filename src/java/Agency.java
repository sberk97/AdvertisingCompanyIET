import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Agency {

    private List<Employee> employeesList;
    private List<Contract> contractsList;

    public Agency() {
        contractsList = new ArrayList<>();
        employeesList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employeesList.add(employee);
    }

    public void addContract(Contract contract) {
        this.contractsList.add(contract);
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public List<Contract> getContractsList() {
        return contractsList;
    }

    public Employee getEmployeeWithLeastNumberOfContracts() {
        return this.employeesList
                .stream()
                .min(Comparator.comparing(Employee::getNumberOfContracts))
                .orElseThrow(NoSuchElementException::new);
    }

    public float getSumOfContractsCosts() {
        float sum = 0;
        for(Contract singleContract : contractsList) {
            sum += singleContract.getCost();
        }
        return sum;
    }
}
