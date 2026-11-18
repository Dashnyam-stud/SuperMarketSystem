
package supermarket;

import java.util.ArrayList;
import java.util.Scanner;

public class SuperMarketSystem {

    private ArrayList<Applicant> applicants;
    private EmployeeBinaryTree employeeTree;
    private Scanner scanner;

    // Constructor
    public SuperMarketSystem() {
        applicants = new ArrayList<>();
        employeeTree = new EmployeeBinaryTree();
        scanner = new Scanner(System.in);
    }

    // Load applicant information from file
    public void loadApplicants(String fileName) {
        ApplicantFileReader reader = new ApplicantFileReader();
        applicants = reader.readApplicants(fileName);

        System.out.println("Total applicants loaded: " + applicants.size());
    }

    // Sort applicants using Merge Sort
    public void sortApplicants() {
        MergeSort.sort(applicants);
    }

    // Display all applicants
    public void displayApplicants() {
        for (Applicant applicant : applicants) {
            applicant.displayApplicant();
        }
    }

    // Add employees to Binary Tree
    public void addEmployeesToTree() {

        for (Applicant applicant : applicants) {

            Employee employee = new Employee(
                    applicant.getFullName(),
                    applicant.getDesignation(),
                    applicant.getDepartment()
            );

            employeeTree.insert(employee);
        }
    }

    // Display main menu
    public void displayMenu() {

        int choice;

        do {
            System.out.println("\n===== SUPERMARKET SYSTEM =====");
            System.out.println("1. Display Applicants");
            System.out.println("2. Search Applicant");
            System.out.println("3. Display Employees");
            System.out.println("4. Display Tree Height");
            System.out.println("5. Display Total Employees");
            System.out.println("6. Add New Employee");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    displayApplicants();
                    break;

                case 2:
                    System.out.print("Enter applicant name: ");
                    String name = scanner.nextLine();

                    Applicant foundApplicant
                            = RecursiveBinarySearch.search(applicants, name);

                    if (foundApplicant != null) {
                        System.out.println("\nApplicant Found!");
                        System.out.println("Name: " + foundApplicant.getFullName());
                        System.out.println("Manager Type: " + foundApplicant.getDesignation());
                        System.out.println("Department Name: " + foundApplicant.getDepartment());
                    } else {
                        System.out.println("Applicant not found.");
                    }
                    break;

                case 3:
                    employeeTree.levelOrderTraversal();
                    break;

                case 4:
                    System.out.println("Tree Height: "
                            + employeeTree.getTreeHeight());
                    break;

                case 5:
                    System.out.println("Total Employees: "
                            + employeeTree.getTotalNodes());
                    break;

                case 6:
                    addNewEmployee();
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);
    }

    // Add a new employee
    public void addNewEmployee() {
        System.out.println("\n===== ADD NEW EMPLOYEE =====");
    }
}
