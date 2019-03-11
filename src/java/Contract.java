import java.util.ArrayList;
import java.util.List;

public class Contract {

    private float cost;
    private int maxNumberOfDesigners;
    private List<Employee> designersTeam;

    public Contract(float cost, int maxNumberOfDesigners) {
        this.cost = cost;
        this.maxNumberOfDesigners = maxNumberOfDesigners;
        designersTeam = new ArrayList<>();
    }

    public float getCost() {
        return cost;
    }

    public List<Employee> getDesignersTeam() {
        return designersTeam;
    }

    public boolean addDesigner(Agency agency) {
        if(designersTeam.size() < maxNumberOfDesigners) {
            Employee designer = agency.getEmployeeWithLeastNumberOfContracts();
            designersTeam.add(designer);
            designer.increaseNumberOfContracts();
            return true;
        } else {
            return false;
        }
    }
}
