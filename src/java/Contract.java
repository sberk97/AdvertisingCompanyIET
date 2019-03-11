import java.util.List;

public class Contract {

    private float cost;
    private int maxNumberOfDesigners;
    List<Employee> designersTeam;

    public Contract(float cost, int maxNumberOfDesigners) {
        this.cost = cost;
        this.maxNumberOfDesigners = maxNumberOfDesigners;
    }

    public float getCost() {
        return cost;
    }

    public void addDesigner(Employee designer) {
        if(designersTeam.size() < maxNumberOfDesigners) {

            designer.increaseNumberOfContracts();
        }
    }
}
