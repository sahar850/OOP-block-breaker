import java.awt.Color;
import java.awt.Image;
import java.util.Map;

/**
 * this method creats blocks from the file.
 */
public class BlockFileGenerator implements BlockCreator {
    private int width;
    private int height;
    private  Map<Integer, Color> mapcolor;
    private Map<Integer, Image> mapimage;
    private int hits;
    private Color stroke;
    /**
     * @param width the width of the block
     * @param height the height of the block
     * @param hits the num of hit of the block
     * @param stroke the color for the block
     * @param mapcolor the color map (if the hit change it)
     * @param mapimage the image map (if the hit change it)
     */
    public BlockFileGenerator(int width, int height,
                              int hits, Map<Integer, Color> mapcolor, Map<Integer, Image> mapimage, Color stroke) {
        this.width = width;
        this.height = height;
        this.mapcolor = mapcolor;
        this.mapimage = mapimage;
        this.hits = hits;
        this.stroke = stroke;
    }

    /**
     * @param xpos the x point of the block
     * @param ypos the y point of the block
     * @return the new block
     */
    public Block create(int xpos, int ypos) {
        Rectangle r = new Rectangle(new Point(xpos, ypos), this.width, this.height);
        if (this.mapcolor.containsKey(this.hits)) {
            Block b = new Block(r, this.stroke, this.hits, mapcolor,  mapimage,  this.mapcolor.get(this.hits));
            return b;
        }
        Block b = new Block(r, this.stroke, this.hits, mapcolor,  mapimage,  this.mapcolor.get(this.hits));
        return b;
    }

    /**
     *
     * @return the width of the block
     */
    public int getWidth() {
        return this.width;
    }

    /**
     *
     * @return the height of the block
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * @return the num of hit of the block
     */
    public int getHits() {
        return this.hits;
    }
}
