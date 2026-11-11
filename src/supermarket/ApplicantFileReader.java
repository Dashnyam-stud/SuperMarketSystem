
package supermarket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ApplicantFileReader {

    public ArrayList<Applicant> readApplicants(String fileName) {

        ArrayList<Applicant> applicants = new ArrayList<>();

        try (BufferedReader reader =
                new BufferedReader(new FileReader(fileName))) {

            String line;

            // Skip the first line because it contains column names
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                // Split each line into separate columns
                String[] data = line.split(",", -1);

                if (data.length == 9) {

                    Applicant applicant = new Applicant(
                            data[0].trim(),
                            data[1].trim(),
                            data[2].trim(),
                            data[3].trim(),
                            Double.parseDouble(data[4].trim()),
                            data[5].trim(),
                            data[6].trim(),
                            data[7].trim(),
                            data[8].trim()
                    );

                    applicants.add(applicant);
                }
            }

            System.out.println("File loaded successfully!");
            System.out.println("Total applicants: " + applicants.size());

        } catch (IOException e) {

            System.out.println("Error reading file: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("Invalid salary value in file.");
        }

        return applicants;
    }
}
