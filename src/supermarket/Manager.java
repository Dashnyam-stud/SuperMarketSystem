
package supermarket;

public class Manager {

    private String managerName;
    private ManagerType managerType;

    // Constructor
    public Manager(String managerName, ManagerType managerType) {
        this.managerName = managerName;
        this.managerType = managerType;
    }

    // Get manager name
    public String getManagerName() {
        return managerName;
    }

    // Get manager type
    public ManagerType getManagerType() {
        return managerType;
    }

    // Display manager information
    public void displayManager() {
        System.out.println("Manager Name: " + managerName);
        System.out.println("Manager Type: " + managerType);
    }
}
