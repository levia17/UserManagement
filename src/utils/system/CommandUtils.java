package src.utils.system;

import src.utils.FileUtils;

public class CommandUtils {
    public static boolean Choose(String command, String[] parts) {
        String choose = null;

        switch (command) {
            case "cf":
                choose = parts[1];
                return false;
            case "crf":
                System.err.println(choose);
                // FileUtils.createFile(parts[1]);
                return false;
            case "wrf":
                FileUtils.writeFile(parts[1], parts[2]);
                return false;
            case "q":
                return true;
            default:
                System.out.println("Invalid command. Please try again.");
                return false;
        }
    }
}
