import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program reads numbers from "input.txt", calculates the sum
 * of numbers on each line, and writes the results to "output.txt".
 *
 * If a line contains invalid data (non-numbers), an error message
 * is written instead.
 *
 * Author: Angel
 * Version: 1.0
 * Since: 2025-10-16
 */
public final class FileIO {

    /**
     * Private constructor to prevent creating an instance
     * of this utility class.
     */
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Main method to read input, calculate sums, and write output.
     * @param args Unused
     * @throws Exception if file reading/writing fails
     */
    public static void main(final String[] args) throws Exception {
        // Create Scanner object to read from "input.txt"
        Scanner scanner = new Scanner(new File("input.txt"));

        // Create PrintWriter object to write to "output.txt"
        PrintWriter writer = new PrintWriter("output.txt");

        // Read the input file line by line
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine(); // Read one line from the file
            String[] arr = line.split(" "); // Split line into array of strings
            int sum = 0; // Variable to store sum
            boolean hasError = false; // for invalid data

            // Loop through each element of the array
            for (String element : arr) {
                try {
                    int number = Integer.parseInt(element);
                    // Convert to integer
                    sum += number; // Add to sum
                } catch (NumberFormatException e) {
                    hasError = true;
                    break; // Stop processing this line
                }
            }

            // Write result to output file
            if (hasError) {
                writer.println("Error: Invalid input in line -> " + line);
            } else {
                writer.println("Sum: " + sum);
            }
        }

        // close scanner and writer
        scanner.close();
        writer.close();
    }
}
