import org.junit.Test;
import ru.nsu.ccfit.blocks.Grep;

import java.util.ArrayList;
import java.util.Vector;

import static org.junit.Assert.*;

public class GrepTest {

    @Test
    public void execute() throws Exception{
        Grep grep = new Grep();
        ArrayList<String> text = new ArrayList<>();
        Vector<String> args = new Vector<>();
        text.add("word1 word2 word3");
        text.add("word1");
        text.add("word3 word1");
        args.add("word2");
        grep.execute(text, args);
        ArrayList<String> textCorrect = new ArrayList<>();
        textCorrect.add("word1 word2 word3");
        assertEquals(textCorrect, text);
    }
}