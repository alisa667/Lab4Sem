package ru.nsu.ccfit.blocks;
import java.util.*;

public interface Block {
    void execute(ArrayList<String> text, Vector<String> args) throws Exception;
}
