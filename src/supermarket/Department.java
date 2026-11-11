
package supermarket;

public class Department {

    private String departmentName;
    private String departmentDescription;

    // Constructor
    public Department(String departmentName,
            String departmentDescription) {

        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
    }

    // Get department name
    public String getDepartmentName() {
        return departmentName;
    }

    // Get department description
    public String getDepartmentDescription() {
        return departmentDescription;
    }

    // Display department information
    public void displayDepartment() {

        System.out.println("Department Name: " + departmentName);
        System.out.println("Description: " + departmentDescription);
    }
}
