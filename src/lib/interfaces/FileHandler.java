package src.lib.interfaces;

import java.io.File;
import java.util.Scanner;

public interface FileHandler {
    void createFile(String filename);

    void writeFile(File file, String content);

    void editFile(Scanner scanner, File file);

    void readFile(File file);
}
