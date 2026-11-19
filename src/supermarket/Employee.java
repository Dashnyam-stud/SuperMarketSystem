
package supermarket;

public class Employee {

    private String employeeName;
    private Manager manager;
    private Department department;

    // Constructor
    public Employee(String employeeName,
            Manager manager, Department department) {

        this.employeeName = employeeName;
        this.manager = manager;
        this.department = department;
    }

    // Get employee name
    public String getEmployeeName() {
        return employeeName;
    }

    // Get manager information
    public Manager getManager() {
        return manager;
    }

    // Get department information
    public Department getDepartment() {
        return department;
    }

    // Get designation
    public String getDesignation() {
        return manager.getManagerType().toString();
    }

    // Get department name
    public String getDepartmentName() {
        return department.getDepartmentName();
    }

    // Display employee information
    public void displayEmployee() {

        System.out.println("Employee Name: " + employeeName);
        manager.displayManager();
        department.displayDepartment();
    }
}
