package src.service;

import java.io.File;

import src.lib.interfaces.*;
import src.utils.FileUtils;

public class FileInteraction implements FileHandler {
    private String name;
    private String type;
    private File file;
    private FileUtils fileUtils = new FileUtils();

    public FileInteraction(String name) {
        this.name = name;
        this.file = new File(name + ".txt");
    }

    public FileInteraction(String name, String type) {
        this.name = name;
        this.type = type;
        this.file = new File(this.name + this.type);
    }

    public void newFile() {
    }

}