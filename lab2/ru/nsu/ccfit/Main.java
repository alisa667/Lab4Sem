package ru.nsu.ccfit;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger log = Logger.getLogger(BlocksFactory.class.getName());

    public static void main(String[] args) {
        Workflow workflow = new Workflow();
        try {
            workflow.work("C:\\Users\\User\\IdeaProjects\\lab1\\src\\mainFile.txt");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Exception: ", e);
            e.printStackTrace();
        }
    }
}
