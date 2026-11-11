
package supermarket;

import java.util.ArrayList;

public class MergeSort {

    // Main sorting method
    public static void sort(ArrayList<Applicant> applicants) {

        if (applicants == null || applicants.size() <= 1) {
            return;
        }

        mergeSort(applicants, 0, applicants.size() - 1);
    }

    // Recursive Merge Sort method
    private static void mergeSort(ArrayList<Applicant> applicants,
            int left, int right) {

        if (left < right) {

            int middle = (left + right) / 2;

            // Sort the left half
            mergeSort(applicants, left, middle);

            // Sort the right half
            mergeSort(applicants, middle + 1, right);

            // Merge both sorted halves
            merge(applicants, left, middle, right);
        }
    }

    // Merge two sorted sections
    private static void merge(ArrayList<Applicant> applicants,
            int left, int middle, int right) {

        ArrayList<Applicant> temporary = new ArrayList<>();

        int i = left;
        int j = middle + 1;

        while (i <= middle && j <= right) {

            String name1 = applicants.get(i).getFullName();
            String name2 = applicants.get(j).getFullName();

            if (name1.compareToIgnoreCase(name2) <= 0) {
                temporary.add(applicants.get(i));
                i++;
            } else {
                temporary.add(applicants.get(j));
                j++;
            }
        }

        // Add remaining items from the left section
        while (i <= middle) {
            temporary.add(applicants.get(i));
            i++;
        }

        // Add remaining items from the right section
        while (j <= right) {
            temporary.add(applicants.get(j));
            j++;
        }

        // Copy sorted items back to the original list
        for (int k = 0; k < temporary.size(); k++) {
            applicants.set(left + k, temporary.get(k));
        }
    }
}
