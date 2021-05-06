package ru.nsu.ccfit.blocks;

import ru.nsu.ccfit.exceptions.WrongNumOfArgsException;

import java.util.ArrayList;
import java.util.Vector;

public class Dump implements Block{
    @Override
    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {
        if (args.size() != 1) {
            throw new WrongNumOfArgsException("Dump: wrong number of arguments");
        }
        Writefile writer = new Writefile();
        writer.execute(text, args);
    }

}
