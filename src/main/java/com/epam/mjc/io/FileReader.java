package com.epam.mjc.io;

import java.io.*;
import java.util.logging.*;


public class FileReader {
private Logger logger;
    public Profile getDataFromFile(File file) {
        String text = "";
        try (FileInputStream input = new FileInputStream(file)) {
            int ch;
            while ((ch = input.read()) != -1) {
                text += String.valueOf((char) ch);
            }
        } catch (IOException e) {
            logger.log(Level.WARNING,e.getMessage());
        }

        String[] lines = text.split("\\R");


        return new Profile(lines[0].split(" ")[1], Integer.valueOf(lines[1].split(" ")[1]), lines[2].split(" ")[1], Long.valueOf(lines[3].split(" ")[1]));
    }
}
