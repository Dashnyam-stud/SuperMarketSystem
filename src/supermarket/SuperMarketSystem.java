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

    // Display the first 20 applicants
    public void displayApplicants() {

        int limit = Math.min(20, applicants.size());

        for (int i = 0; i < limit; i++) {
            applicants.get(i).displayApplicant();
        }

        System.out.println("\nDisplayed " + limit + " applicants.");
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

            MenuOption[] menuOptions = MenuOption.values();

            for (int i = 0; i < menuOptions.length; i++) {
                System.out.println((i + 1) + ". "
                        + menuOptions[i].getDescription());
            }

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

        System.out.print("Enter employee name: ");
        String employeeName = scanner.nextLine();

        System.out.println("\nSelect Manager Type:");

        ManagerType[] managerTypes = ManagerType.values();

        for (int i = 0; i < managerTypes.length; i++) {
            System.out.println((i + 1) + ". " + managerTypes[i]);
        }

        int managerChoice;

        while (true) {

            System.out.print("Enter Manager Type: ");

            if (scanner.hasNextInt()) {
                managerChoice = scanner.nextInt();
                scanner.nextLine();

                if (managerChoice >= 1 && managerChoice <= managerTypes.length) {
                    break;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Invalid choice. Please try again.");
        }

        String managerType = managerTypes[managerChoice - 1].toString();

        System.out.println("\nSelect Department:");

        DepartmentType[] departmentTypes = DepartmentType.values();

        for (int i = 0; i < departmentTypes.length; i++) {
            System.out.println((i + 1) + ". " + departmentTypes[i]);
        }

        int departmentChoice;

        while (true) {

            System.out.print("Enter Department: ");

            if (scanner.hasNextInt()) {
                departmentChoice = scanner.nextInt();
                scanner.nextLine();

                if (departmentChoice >= 1 && departmentChoice <= departmentTypes.length) {
                    break;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("Invalid choice. Please try again.");
        }

        String departmentName = departmentTypes[departmentChoice - 1].toString();

        Employee newEmployee = new Employee(
                employeeName,
                managerType,
                departmentName
        );

        employeeTree.insert(newEmployee);

        System.out.println("\nNew employee added successfully!");
        newEmployee.displayEmployee();
    }
}
