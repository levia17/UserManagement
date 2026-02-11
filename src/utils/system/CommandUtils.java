package src.utils.system;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import src.utils.FileUtils;

/**
 * Utility class for handling user commands in the User Management system.
 */
public class CommandUtils {
    
    /**
     * Processes user commands and delegates to appropriate file operations.
     * 
     * @param scanner the Scanner instance for reading user input
     * @param command the command to execute
     * @param parts the command split into parts (command and arguments)
     * @return true if the user wants to exit, false otherwise
     */
    public static boolean Choose(Scanner scanner, String command, String[] parts) {
        FileUtils fileUtils = new FileUtils();
        
        try {
            switch (command) {
                case "crf":
                    if (parts.length < 2) {
                        System.out.println("Usage: crf <filename>");
                        return false;
                    }
                    fileUtils.createFile(parts[1]);
                    return false;
                    
                case "wrf":
                    if (parts.length < 3) {
                        System.out.println("Usage: wrf <path/to/filename> <content>");
                        return false;
                    }
                    // Combine all array elements beyond the index 1 for the content
                    String content = String.join(" ", Arrays.copyOfRange(parts, 2, parts.length));
                    fileUtils.writeFile(new File(parts[1]), content);
                    return false;
                    
                case "rdf":
                    if (parts.length < 2) {
                        System.out.println("Usage: rdf <path/to/filename>");
                        return false;
                    }
                    fileUtils.readFile(new File(parts[1]));
                    return false;
                    
                case "edf":
                    if (parts.length < 2) {
                        System.out.println("Usage: edf <path/to/filename>");
                        return false;
                    }
                    fileUtils.editFile(scanner, new File(parts[1]));
                    return false;
                    
                case "help":
                    printHelp();
                    return false;
                    
                case "q":
                    System.out.println("Exiting....");
                    return true;
                    
                default:
                    System.out.println("Invalid command. Type 'help' for available commands.");
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Missing required arguments. Type 'help' for command usage.");
            return false;
        } catch (Exception e) {
            System.out.println("Error executing command: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Prints help information showing all available commands.
     */
    private static void printHelp() {
        System.out.println("\n--- Available Commands ---");
        System.out.println("crf <filename>              - Create a new file");
        System.out.println("wrf <filename> <content>    - Write content to a file");
        System.out.println("rdf <filename>              - Read and display file contents");
        System.out.println("edf <filename>              - Edit file (find and replace)");
        System.out.println("help                        - Show this help message");
        System.out.println("q                           - Quit the application");
        System.out.println();
    }
}
