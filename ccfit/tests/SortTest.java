import org.junit.Test;
import ru.nsu.ccfit.blocks.Sort;

import java.util.ArrayList;
import java.util.Vector;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void execute() throws Exception{
        Sort sort = new Sort();
        ArrayList<String> text = new ArrayList<>();
        Vector<String> args = new Vector<>();
        text.add("String1");
        text.add("string1");
        text.add("astring1");
        text.add("string01");
        sort.execute(text, args);
        ArrayList<String> textCorrect = new ArrayList<>();
        textCorrect.add("astring1");
        textCorrect.add("string01");
        textCorrect.add("String1");
        textCorrect.add("string1");
        assertEquals(textCorrect, text);
    }
}