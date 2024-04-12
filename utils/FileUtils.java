package utils;

import java.io.File;

public class FileUtils {

    public static void createFile(File file) {
        try {
            boolean createNewFile = file.createNewFile();
            if (createNewFile) {
                System.out.println(file.getName() + " is created!");
            } else {
                System.out.println(file.getName() + " is already existed!");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
