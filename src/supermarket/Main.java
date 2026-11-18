
package supermarket;

public class Main {

    public static void main(String[] args) {

        // Create the supermarket system
        SuperMarketSystem system = new SuperMarketSystem();

        // Load applicant data from file
        system.loadApplicants("Applicants_Form.txt");

        // Sort applicants by name
        system.sortApplicants();

        // Add employees to the Binary Search Tree
        system.addEmployeesToTree();

        // Display the main menu
        system.displayMenu();
    }
}
