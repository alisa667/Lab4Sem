package ru.nsu.ccfit.blocks;

import ru.nsu.ccfit.exceptions.WrongNumOfArgsException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

public class Sort implements Block{
    @Override
    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {
        if (args.size() != 0) {
            throw new WrongNumOfArgsException("Sort: wrong number of arguments");
        }
        text.sort(String::compareToIgnoreCase);
    }
}
