package src.lib.interfaces;

import java.util.Scanner;

/**
 * Interface for command handling in the User Management system.
 * Implementations of this interface should provide command processing logic.
 */
public interface CommandHandler {
    /**
     * Processes a command with its arguments.
     * 
     * @param scanner the Scanner instance for reading user input
     * @param command the command to process
     * @param parts the command split into parts (command and arguments)
     * @return true if the application should exit, false otherwise
     */
    boolean processCommand(Scanner scanner, String command, String[] parts);
} 
