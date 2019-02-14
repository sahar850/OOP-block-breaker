/**
 * Created by Sahar on 30/06/2016.
 */
public interface BlockCreator {
    /**
     * @param xpos the x point of the block
     * @param ypos the y point of the block
     * @return the new block
     */
    Block create(int xpos, int ypos);
}