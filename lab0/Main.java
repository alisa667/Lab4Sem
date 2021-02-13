package ru.nsu.ccfit;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        WordCounter obj = new WordCounter();
        try {
            obj.readWords("in.txt");
            obj.writeToFile("out.txt");
        }
        catch (IOException ex) {
            System.err.println("Error: " + ex.getLocalizedMessage());
        }

    }
}
