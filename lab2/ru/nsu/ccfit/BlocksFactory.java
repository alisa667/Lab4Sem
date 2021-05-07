package ru.nsu.ccfit;

import ru.nsu.ccfit.blocks.Block;
import ru.nsu.ccfit.exceptions.WrongBlockNameException;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class BlocksFactory {

    private static Logger log = Logger.getLogger(BlocksFactory.class.getName());

    private final Properties properties = new Properties();
    private static volatile BlocksFactory factory = null;

    private BlocksFactory() throws Exception{
        InputStream inStream = BlocksFactory.class.getResourceAsStream("blocksDefinitions.properties");
        properties.load(inStream);
        inStream.close();

    }

    public static BlocksFactory getInstance() throws Exception{
        if (factory == null) {
            synchronized (BlocksFactory.class) {
                if (factory == null) {
                    factory = new BlocksFactory();
                }
            }
        }
        return factory;
    }

    public Block create(String blockName) throws Exception{
        Block block;
        String className = properties.getProperty(blockName);
        if (className == null) {
            throw new WrongBlockNameException(blockName + ": wrong class name");
            }
        Class<?> blockClass = Class.forName(className);
        Object blockInstance = blockClass.getDeclaredConstructor().newInstance();
        block = (Block) blockInstance;

        log.info("block " + blockName + " created successfully");
        return block;
    }
}
