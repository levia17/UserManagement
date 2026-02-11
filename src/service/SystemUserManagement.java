package src.service;

import java.util.Scanner;

import src.lib.interfaces.SystemUserManagementHandler;
import src.utils.system.CommandUtils;

/**
 * Main system class for User Management application.
 * Handles user interaction and command processing.
 */
public class SystemUserManagement implements SystemUserManagementHandler {
    private final Scanner scanner;
    private final CommandUtils commandUtils;

    /**
     * Constructor for SystemUserManagement.
     * 
     * @param scanner the Scanner instance for reading user input
     */
    public SystemUserManagement(Scanner scanner) {
        this.scanner = scanner;
        this.commandUtils = new CommandUtils();
    }

    /**
     * Initializes the User Management system and starts the command loop.
     * Displays a welcome message and processes user commands until exit.
     */
    @Override
    public void init() {
        boolean exit = false;
        System.out.println("\n=================================");
        System.out.println("   User Management System");
        System.out.println("=================================");
        System.out.println("Type 'help' for available commands\n");

        while (!exit) {
            System.out.print("Command: ");
            String input = this.scanner.nextLine().trim();
            
            // Skip empty input
            if (input.isEmpty()) {
                continue;
            }
            
            String[] parts = input.split("\\s+");
            String command = parts[0].toLowerCase();
            
            exit = commandUtils.choose(this.scanner, command, parts);
        }

        System.out.println("Thank you for using User Management System!");
        scanner.close();
    }

}