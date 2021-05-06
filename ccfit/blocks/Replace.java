package ru.nsu.ccfit.blocks;

import ru.nsu.ccfit.exceptions.WrongNumOfArgsException;

import java.util.ArrayList;
import java.util.Vector;

public class Replace implements Block{
    @Override
    public void execute(ArrayList<String> text, Vector<String> args) throws Exception {
        if (args.size() != 2) {
            throw new WrongNumOfArgsException("Replace: wrong number of arguments");
        }
        String word1 = args.get(0);
        String word2 = args.get(1);
        for (int i = 0; i < text.size(); i++){
            String line = text.get(i).replaceAll(word1, word2);
            if (!line.equals(text.get(i))){
                text.add(i, line);
                text.remove(i+1);
            }
        }
    }
}
