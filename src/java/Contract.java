import java.util.ArrayList;
import java.util.List;

public class Contract {

    private float cost;
    private int maxNumberOfDesigners;
    List<Employee> designersTeam;

    public Contract(float cost, int maxNumberOfDesigners) {
        this.cost = cost;
        this.maxNumberOfDesigners = maxNumberOfDesigners;
        designersTeam = new ArrayList<>();
    }

    public float getCost() {
        return cost;
    }

    public boolean addDesigner() {
        if(designersTeam.size() < maxNumberOfDesigners) {
            Employee designer = Agency.getEmployeeWithLeastNumberOfContracts();
            designersTeam.add(designer);
            designer.increaseNumberOfContracts();
            return true;
        } else {
            return false;
        }
    }
}
