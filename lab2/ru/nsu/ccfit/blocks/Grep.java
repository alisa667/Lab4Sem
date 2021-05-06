package ru.nsu.ccfit.blocks;

import ru.nsu.ccfit.exceptions.WrongNumOfArgsException;

import java.util.ArrayList;
import java.util.Vector;

public class Grep implements Block {
    @Override
    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {
        if (args.size() != 1) {
            throw new WrongNumOfArgsException("Grep: wrong number of arguments");
        }
        String word = args.get(0);
        int count = 0;
        for (int i = 0; i < text.size(); i++){
            if (text.get(i).lastIndexOf(word) == -1){
                text.remove(i);
                i--;
            }
        }
    }
}