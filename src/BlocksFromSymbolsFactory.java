import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Sahar on 30/06/2016.
 */
public class BlocksFromSymbolsFactory {
    private Map<String, Integer> spacerWidths;
    private Map<String, BlockCreator> blockCreators;
    /**
     *
     */
    public BlocksFromSymbolsFactory() {
        this.spacerWidths = new TreeMap<String, Integer>();
        this.blockCreators = new TreeMap<String, BlockCreator>();
    }

    /**
     * @param s a string with the info from the file
     * @return true or false if is a space
     */
    public boolean isSpaceSymbol(String s) {
        return this.spacerWidths.containsKey(s);
    }
    // returns true if 's' is a valid block symbol.

    /**
     * @param s a string with the info from the file
     * @return true or false if is a valid block
     */
    public boolean isBlockSymbol(String s) {
     return this.blockCreators.containsKey(s);
    }

    // Return a block according to the definitions associated
    // with symbol s. The block will be located at position (xpos, ypos).

    /**
     * @param s a string with the info from the file
     * @param xpos the x point
     * @param ypos the y point
     * @return a new block
     */
    public Block getBlock(String s, int xpos, int ypos) {
        return this.blockCreators.get(s).create(xpos, ypos);
    }

    // Returns the width in pixels associated with the given spacer-symbol.

    /**
     *
     * @param s a string with the info from the file
     * @return the width
     */
    public int getSpaceWidth(String s) {
        return this.spacerWidths.get(s);
    }

    /**
     *
     * @param s a string with the info from the file
     * @param i set a new width
     */
    public void setSpaceWidth(String s, int i) {
        this.spacerWidths.put(s, i);
    }

    /**
     *
     * @param s a string with the info from the file
     * @param b set a new block
     */
    public void setBlock(String s, BlockCreator b) {
        this.blockCreators.put(s, b);
    }
}