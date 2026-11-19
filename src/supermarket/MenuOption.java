package supermarket;

public enum MenuOption {

    DISPLAY_APPLICANTS("Display Applicants"),
    SEARCH_APPLICANT("Search Applicant"),
    DISPLAY_EMPLOYEES("Display Employees"),
    DISPLAY_TREE_HEIGHT("Display Tree Height"),
    DISPLAY_TOTAL_EMPLOYEES("Display Total Employees"),
    ADD_NEW_EMPLOYEE("Add New Employee"),
    EXIT("Exit");

    private String description;

    // Constructor
    MenuOption(String description) {
        this.description = description;
    }

    // Return menu description
    public String getDescription() {
        return description;
    }
}