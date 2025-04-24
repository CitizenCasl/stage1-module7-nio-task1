package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile newProfile = new Profile();

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] row = currentLine.split(":");
                switch (row[0].trim()) {
                    case "Name":
                        newProfile.setName(row[1].trim());
                        break;
                    case "Age":
                        newProfile.setAge(Integer.parseInt(row[1].trim()));
                        break;
                    case "Email":
                        newProfile.setEmail(row[1].trim());
                        break;
                    case "Phone":
                        newProfile.setPhone(Long.parseLong(row[1].trim()));
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newProfile;
    }
}
