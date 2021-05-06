import org.junit.Test;
import ru.nsu.ccfit.blocks.Replace;

import java.util.ArrayList;
import java.util.Vector;

import static org.junit.Assert.*;

public class ReplaceTest {
    @Test
    public void execute() throws Exception{
        Replace replace = new Replace();
        ArrayList<String> text = new ArrayList<>();
        Vector<String> args = new Vector<>();
        text.add("String1");
        text.add("string1");
        text.add("astring1");
        text.add("string01");
        args.add("str");
        args.add("STP");
        replace.execute(text, args);
        ArrayList<String> textCorrect = new ArrayList<>();
        textCorrect.add("String1");
        textCorrect.add("STPing1");
        textCorrect.add("aSTPing1");
        textCorrect.add("STPing01");
        assertEquals(textCorrect, text);
    }
}