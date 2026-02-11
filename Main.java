import java.util.Scanner;

import src.service.SystemUserManagement;

/**
 * Main entry point for the User Management application.
 */
public class Main {
    /**
     * Main method that starts the User Management system.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SystemUserManagement system = new SystemUserManagement(scanner);
        system.init();
    }
}