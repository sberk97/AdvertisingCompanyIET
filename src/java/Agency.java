import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Agency {

    List<Employee> employeesList;
    List<Contract> contractsList;

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

    public Employee getEmployeeWithLeastNumberOfContracts() {
        Employee minByNumberOfContracts = employeesList
                .stream()
                .min(Comparator.comparing(Employee::getNumberOfContracts))
                .orElseThrow(NoSuchElementException::new);
        return minByNumberOfContracts;
    }

    public float getSumOfContractsCosts() {
        float sum = 0;
        for(Contract singleContract : contractsList) {
            sum += singleContract.getCost();
        }
        return sum;
    }


}
