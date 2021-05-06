package ru.nsu.ccfit.blocks;

import ru.nsu.ccfit.exceptions.WrongNumOfArgsException;

import java.util.ArrayList;
import java.util.Vector;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Readfile implements Block{
    @Override
    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {
        if (args.size() != 1) {
            throw new WrongNumOfArgsException("Readfile: wrong number of arguments");
        }
        String nameOfFile = args.get(0);

        File file = new File(nameOfFile);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        while (line != null) {
            text.add(line);
            line = reader.readLine();
        }
        reader.close();
    }

}
