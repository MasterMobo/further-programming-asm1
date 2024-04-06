package io.files;

// Credit:
//  - File writing: https://www.baeldung.com/java-write-to-file
//  - File reading: https://www.baeldung.com/reading-file-in-java
//  - Check file exist: https://stackoverflow.com/a/1816676

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;

public class FileIOHandler {

    public FileIOHandler() {
    }

    public boolean dirExists(String path) {
        File f = new File(path);
        return f.exists();
    }

    public void createDir(String path) {
        File directory = new File(path);
        directory.mkdir();
    }

    public boolean writeTo(String filePath, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);

            writer.close();
            return true;
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return false;
        }
    }

    public String readFrom(String filePath) {
        StringBuilder s = new StringBuilder();

        try {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while((line = br.readLine()) != null){
                s.append(line);
                s.append("\n");
            }
            br.close();
            return s.toString();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            return null;
        }
    }
}