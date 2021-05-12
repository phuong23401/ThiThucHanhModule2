package storage;

import model.Directory;

import java.io.*;

import static controller.Manager.DIRECTORY_LIST;

public class IOFile {
    public static void writeDirectoryList() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Contacts.txt"));
            for (Directory directory : DIRECTORY_LIST) {
                bufferedWriter.write(directory.toString1());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readDirectoryList() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Contacts.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
