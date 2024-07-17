package util;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class DirectorySystem {

    private ArrayList<String> directories = new ArrayList<>();
    private String currentDir = directories.get(2);

    public ArrayList<String> getDirectories() {
        return directories;
    }

    public DirectorySystem() {
        directories.add("/");
        directories.add("home/");
        directories.add("user/");
    }

    public void addDirectory(String dirName) {
        directories.add(dirName);
    }

    public void removeDirectory(String dirName) {
        for (String dir : directories) {
            if (dir.compareTo(dirName) == 0) {
                directories.remove(dir);
            }
        }
    }

    public void showDirectories() {

    }

    public void setDirectories(ArrayList<String> directories) {
        this.directories = directories;
    }

    public String getCurrentDir() {
        return currentDir;
    }

    public void setCurrentDir(String currentDir) {
        this.currentDir = currentDir;
    }
}
