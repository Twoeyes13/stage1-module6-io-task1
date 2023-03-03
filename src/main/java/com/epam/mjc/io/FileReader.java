package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String text = "";
//        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try (FileInputStream input = new FileInputStream(file)) {
            int ch;
            while ((ch = input.read()) != -1) {
                text += String.valueOf((char)ch);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {

        }

        String[] lines = text.split("\\R");


        return new Profile(lines[0].split(" ")[1], Integer.valueOf(lines[1].split(" ")[1]), lines[2].split(" ")[1], Long.valueOf(lines[3].split(" ")[1]));
    }

    public static void main(String[] args) {
        String text = "";
        try (FileInputStream input = new FileInputStream("/home/user/IdeaProjects/stage1-module6-io-task1/src/main/resources/Profile.txt")) {
//            if (input.read() == -1) System.out.println("Empty");
            int ch;
            while ((ch = input.read()) != -1) {
                text += (char)ch;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {

        }

        String[] lines = text.split("\\R");
        String name = lines[0].split(" ")[1];


        System.out.println(name);

    }
}
