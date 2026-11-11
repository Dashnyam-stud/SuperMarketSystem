
package supermarket;

public class Manager {

    private String managerName;
    private String managerType;

    // Constructor
    public Manager(String managerName, String managerType) {
        this.managerName = managerName;
        this.managerType = managerType;
    }

    // Get manager name
    public String getManagerName() {
        return managerName;
    }

    // Get manager type
    public String getManagerType() {
        return managerType;
    }

    // Display manager information
    public void displayManager() {
        System.out.println("Manager Name: " + managerName);
        System.out.println("Manager Type: " + managerType);
    }
}
