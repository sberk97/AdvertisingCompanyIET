import java.util.ArrayList;
import java.util.List;

/**
 * This class keeps a cost of a contract,
 * maximum number of designers that can work
 * on this contract, and a list of designers
 * that are working on contract
 */
public class Contract {

    private float cost;
    private int maxNumberOfDesigners;
    private List<Employee> designersTeam;

    public Contract(float cost, int maxNumberOfDesigners) {
        if(cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Cost can't be negative");
        }

        if(maxNumberOfDesigners > 0) {
            this.maxNumberOfDesigners = maxNumberOfDesigners;
        } else {
            throw new IllegalArgumentException("Minimum one designer is required");
        }
        designersTeam = new ArrayList<>();
    }

    public float getCost() {
        return cost;
    }

    public List<Employee> getDesignersTeam() {
        return designersTeam;
    }

    /**
     * Methods checks number of designers in a team
     * and if it is less than maximum number of designers
     * than can be applied to the team employee will be added
     * @param agency Agency from which employee will be added
     * @return true if employee is added, false if there are
     * more designers in the team than maximum number allowed
     */
    public boolean addDesigner(Agency agency) {
        if(designersTeam.size() < this.maxNumberOfDesigners) {
            Employee designer = agency.getEmployeeWithLeastNumberOfContracts(designersTeam);
            designersTeam.add(designer);
            designer.increaseNumberOfContracts();
            return true;
        } else {
            return false;
        }
    }
}
