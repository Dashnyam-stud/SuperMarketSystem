package supermarket;

public class Applicant {

    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private double salary;
    private String department;
    private String position;
    private String jobTitle;
    private String company;

    public Applicant(String firstName, String lastName,
            String gender, String email, double salary,
            String department, String position,
            String jobTitle, String company) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
        this.company = company;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public String getGender() {
        return gender;
    }

    // Display applicant information
    public void displayApplicant() {
        System.out.println("Name: " + getFullName());
        System.out.println("Gender: " + gender);
        System.out.println("Email: " + email);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Company: " + company);
    }

// Return job title as manager type
        // Get employee designation
    public String getDesignation() {
        return position;
    
    }
}
