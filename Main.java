import java.io.File;

import service.*;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        // Create FileInteraction instance with a base filename of "test"
        FileInteraction test = new FileInteraction("test", ".dat");

        // Create a new text file named "test.txt"
        test.newFile();
    }

}