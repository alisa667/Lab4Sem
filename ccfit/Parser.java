package ru.nsu.ccfit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import ru.nsu.ccfit.exceptions.WrongFormatException;

public class Parser {
    private final Vector <String> commands;
    private final Map <String, Vector<String>> blocks;

    public Parser() {
        commands = new Vector<>();
        blocks = new HashMap<>();
    }

    public void parse(String commandFileName) throws Exception{
        File file = new File(commandFileName);
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        boolean csedFound = false;
        String line = reader.readLine();

        if (!line.equals("desc")){
            throw new WrongFormatException("No desc!");
        }
        line = reader.readLine();
        while(line != null){
            String[] argument = line.split(" ");
            if (argument.length < 3 && !line.equals("csed")){
                throw new WrongFormatException(line + ": too short line");
            }
            Vector <String> parsedString = new Vector<>();
            Collections.addAll(parsedString, argument);
            if (parsedString.size() == 1 && parsedString.get(0).equals("csed")){
                csedFound = true;
                break;
            }
            String number = parsedString.get(0);
            parsedString.remove(0);
            if (!parsedString.get(0).equals("=")){
                throw new WrongFormatException(line + ": missing '='");
            }
            parsedString.remove(0);
            blocks.put(number, parsedString);
            line = reader.readLine();
        }
        if (!csedFound){
            throw new WrongFormatException("No cesc!");
        }
        line = reader.readLine();
        if (line != null) {
            String[] argument = line.split(" ");
            for (String word : argument) {
                if (!word.equals("->")) {
                    if (!blocks.containsKey(word)) {
                        throw new WrongFormatException(word + ": wrong block number");
                    }
                    commands.add(word);
                }
            }
        }
    }

    public Map <String, Vector<String>> getBlocks(){
        return blocks;
    }

    public Vector <String> getCommands(){
        return commands;
    }

}
