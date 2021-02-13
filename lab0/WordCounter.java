package ru.nsu.ccfit;
import java.io.*;
import java.util.*;

public class WordCounter {
    private HashMap<String, Integer> words;
    private int countAllWords;

    WordCounter(){
        words = new HashMap<>();
        countAllWords = 0;
    }

    public void readWords(String fileInName) throws IOException{
        Reader reader = new InputStreamReader(new FileInputStream(fileInName));
        StringBuilder word = new StringBuilder();
        int letter = reader.read();
        while(letter != -1){
            if (Character.isLetterOrDigit(letter))
               word.append((char)letter);
            else if (word.length() > 0){
                putToMap(word.toString());
                word.delete(0, word.length());
            }
            letter = reader.read();
        }
        if (word.length() > 0)
            putToMap(word.toString());
        reader.close();
    }

    private void putToMap(String str){
        if (words.get(str) == null)
            words.put(str, 1);
        else {
            int i = words.get(str);
            words.put(str, i + 1);
        }
    }

    public void writeToFile(String fileOutName) throws IOException{

            Writer writer = new OutputStreamWriter(new FileOutputStream(fileOutName));
            ArrayList<Pair<String, Integer>> listToSort = new ArrayList();
            for (String key : words.keySet()) {
                Pair<String, Integer> pair = new Pair(key, words.get(key));
                listToSort.add(pair);
                countAllWords+=words.get(key);
            }
            listToSort.sort((arg1, arg2) -> -(arg1.getSecond()).compareTo(arg2.getSecond()));
            for (Pair<String, Integer> i : listToSort){
                writer.write(i.getFirst() + "," + (float)100 * i.getSecond() / countAllWords + "\n");
            }
            writer.close();


    }
}
