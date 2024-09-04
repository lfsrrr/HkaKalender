import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Studiengang:");
        String studiengang = scanner.nextLine();  // Read user input

        // Construct the curl command using the user input
        String[] curlCommand = {
                "curl",
                "-X", "GET",
                "https://raumzeit.hka-iwi.de/api/v1/timetables/public/" + studiengang,
                "-H", "accept: text/calendar"
        };

        try {
            // Execute the curl command using ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder(curlCommand);
            Process process = processBuilder.start();

            // Read the output of the curl command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                // Write the API response to a .ics file
                String fileName = studiengang + ".ics";
                try (FileWriter fileWriter = new FileWriter(fileName)) {
                    fileWriter.write(output.toString());
                    System.out.println("API response saved to " + fileName);
                }
            } else {
                System.err.println("Error: API call failed with exit code " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();  // Handle any exceptions
        }
    }
}