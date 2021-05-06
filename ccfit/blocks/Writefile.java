package ru.nsu.ccfit.blocks;

import ru.nsu.ccfit.exceptions.WrongNumOfArgsException;

import java.util.ArrayList;
import java.util.Vector;
import java.io.FileWriter;

public class Writefile implements Block{
    @Override
    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {
        if (args.size() != 1) {
            throw new WrongNumOfArgsException("Writefile: wrong number of arguments");
        }
        String nameOfFile = args.get(0);
        FileWriter writer = new FileWriter(nameOfFile);
        for (var line : text){
            writer.write(line);
            writer.write("\n");
        }
        writer.close();
    }

}
