package supermarket;

import java.util.ArrayList;

public class RecursiveBinarySearch {

    // Search for an applicant by full name
    public static Applicant search(ArrayList<Applicant> applicants,
            String searchName) {

        if (applicants == null || applicants.isEmpty()) {
            return null;
        }

        return binarySearch(applicants, searchName, 0,
                applicants.size() - 1);
    }

    // Recursive Binary Search method
    private static Applicant binarySearch(
            ArrayList<Applicant> applicants,
            String searchName, int left, int right) {

        // Stop searching when no items remain
        if (left > right) {
            return null;
        }

        int middle = (left + right) / 2;

        String currentName
                = applicants.get(middle).getFullName();

        int result = currentName.compareToIgnoreCase(searchName);

        // Name found
        if (result == 0) {
            return applicants.get(middle);
        }

        // Search the left half
        if (result > 0) {
            return binarySearch(applicants, searchName,
                    left, middle - 1);
        }

        // Search the right half
        return binarySearch(applicants, searchName,
                middle + 1, right);
    }
}
