package src.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void createFile(String name) {
        try {
            if (name == null) {
                System.err.println("Please enter file's name!");
                throw new Exception();
            }

            File file = new File(name);
            boolean createNewFile = file.createNewFile();
            if (createNewFile) {
                System.out.println(file.getName() + " is created!");
            } else {
                System.out.println(file.getName() + " is already existed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String filename, String content) {
        // Ensure the .dat extension in the filename
        String filePath = filename.endsWith(".dat") ? filename : filename + ".dat";

        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(content);
            writer.newLine(); // Adds a new line after writing the content
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
