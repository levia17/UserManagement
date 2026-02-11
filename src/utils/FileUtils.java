package src.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import src.lib.interfaces.FileHandler;

/**
 * Utility class for file operations including create, read, write, and edit.
 */
public class FileUtils implements FileHandler {

    /**
     * Creates a new file with the specified filename.
     * 
     * @param filename the name of the file to create
     */
    @Override
    public void createFile(String filename) {
        if (filename == null || filename.trim().isEmpty()) {
            System.out.println("Error: Please enter a valid file name!");
            return;
        }

        try {
            File file = new File(filename);
            boolean createNewFile = file.createNewFile();
            if (createNewFile) {
                System.out.println("File created: " + file.getPath());
            } else {
                System.out.println("File already exists: " + file.getPath());
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Error: Permission denied to create file.");
        }
    }

    /**
     * Writes content to a file. Creates the file if it doesn't exist.
     * Appends to the file if it already exists.
     * 
     * @param file the file to write to
     * @param content the content to write
     */
    @Override
    public void writeFile(File file, String content) {
        if (file == null) {
            System.out.println("Error: File cannot be null.");
            return;
        }
        
        if (content == null) {
            System.out.println("Warning: Writing empty content to file.");
            content = "";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content);
            writer.newLine(); // Adds a new line after writing the content
            System.out.println("Successfully wrote to the file: " + file.getPath());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Error: Permission denied to write to file.");
        }
    }

    /**
     * Edits a file by finding and replacing text.
     * Prompts the user for search text and replacement text.
     * 
     * @param scanner the Scanner instance for reading user input
     * @param file the file to edit
     */
    @Override
    public void editFile(Scanner scanner, File file) {
        if (!validateFileForReading(file)) {
            return;
        }

        StringBuilder contentBuilder = new StringBuilder();
        System.out.println("Enter text to replace: ");
        String searchText = scanner.nextLine();
        System.out.println("Enter replacement text: ");
        String replacementText = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Replace the search text with the replacement text in the current line
                contentBuilder.append(line.replaceAll(searchText, replacementText));
                contentBuilder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        } catch (java.util.regex.PatternSyntaxException e) {
            System.out.println("Error: Invalid search pattern. Please use valid text or regex.");
            return;
        }

        // Write the new content to the file
        try (FileWriter writer = new FileWriter(file.getPath())) {
            writer.write(contentBuilder.toString());
            System.out.println("File edited successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads and displays the contents of a file.
     * 
     * @param file the file to read
     */
    @Override
    public void readFile(File file) {
        if (!validateFileForReading(file)) {
            return;
        }
        
        // Using try-with-resources to ensure the reader is closed properly
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n--- File Contents: " + file.getName() + " ---");
            // Read lines from the file until no more are present
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("--- End of File ---\n");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    /**
     * Validates that a file exists and is readable.
     * 
     * @param file the file to validate
     * @return true if the file exists and can be read, false otherwise
     */
    private boolean validateFileForReading(File file) {
        if (file == null) {
            System.out.println("Error: File cannot be null.");
            return false;
        }
        
        if (!file.exists()) {
            System.out.println("Error: File does not exist: " + file.getPath());
            return false;
        }
        
        if (!file.isFile()) {
            System.out.println("Error: Path is not a file: " + file.getPath());
            return false;
        }
        
        if (!file.canRead()) {
            System.out.println("Error: Permission denied to read file: " + file.getPath());
            return false;
        }
        
        return true;
    }

}
