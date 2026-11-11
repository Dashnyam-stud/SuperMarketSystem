
package supermarket;

public class Employee {

    private String employeeName;
    private String designation;
    private String departmentName;

    // Constructor
    public Employee(String employeeName,
            String designation, String departmentName) {

        this.employeeName = employeeName;
        this.designation = designation;
        this.departmentName = departmentName;
    }

    // Get employee name
    public String getEmployeeName() {
        return employeeName;
    }

    // Get designation
    public String getDesignation() {
        return designation;
    }

    // Get department name
    public String getDepartmentName() {
        return departmentName;
    }

    // Display employee information
    public void displayEmployee() {

        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
        System.out.println("Department: " + departmentName);
    }
}
