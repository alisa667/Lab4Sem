package ru.nsu.ccfit;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Logger;

import ru.nsu.ccfit.blocks.Block;

public class Workflow {
    private static Logger log = Logger.getLogger(BlocksFactory.class.getName());
    public void work(String fileName) throws Exception{
        Parser parser = new Parser();
        parser.parse(fileName);

        Map<String, Vector<String>> blocks = parser.getBlocks();
        Vector <String> commands = parser.getCommands();
        ArrayList<String> text = new ArrayList<>();
        for (String command : commands) {
            String blockName = blocks.get(command).get(0);
            Vector<String> args = new Vector<>();
            for (int j = 1; j < blocks.get(command).size(); j++) {
                args.add(blocks.get(command).get(j));
            }
            Block block = BlocksFactory.getInstance().create(blockName);
            block.execute(text, args);
            log.info("block " + blockName + " was executed");
        }
    }
}
