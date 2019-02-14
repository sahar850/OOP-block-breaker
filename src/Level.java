import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahar on 30/06/2016.
 */
public class Level implements LevelInformation {
    private String name;
    private Integer paddleSpeed;
    private Integer paddleWidth;
    private Integer blocksStartX;
    private Integer blocksStartY;
    private Integer rowHeight;
    private Integer numOfBlocks;
    private Integer numOfBalls;
    private List<Block> blocks;
    private List<Velocity> v;
    private Sprite background;

    /**
     * constractor for levels.
     */
    public Level() {
        this.name = null;
        this.paddleSpeed = null;
        this.paddleWidth = null;
        this.blocksStartX = null;
        this.blocksStartY = null;
        this.rowHeight = null;
        this.numOfBlocks = null;
        this.numOfBalls = null;
        this.blocks = new ArrayList<Block>();
        this.v = new ArrayList<Velocity>();
    }
    /**
     * @return the num of balls in the level
     */
    public int numberOfBalls() {
        return this.numOfBalls;
    }
    /**
     * @param numOfBall the num of balls in the level
     */
    public void setnumberOfBalls(int numOfBall) {
        this.numOfBalls = numOfBall;
    }

    /**
     * @return a list with the balls velocitis
     */
    public List<Velocity> initialBallVelocities() {
        return this.v;
    }


    /**
     * @param velocitie the balls velocity initiation
     */
    public void setinitialBallVelocities(List<Velocity> velocitie) {
        this.v = velocitie;
    }

    /**
     * @return the paddle speed
     */
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     * @param ps the paddle speed idealization
     */
    public void setpaddleSpeed(int ps) {
        this.paddleSpeed = ps;
    }

    /**
     * @return the paddle width
     */
    public int paddleWidth() {
        return this.paddleWidth;
    }
    /**
     *
     * @param pw the paddle width
     */
    public void setpaddleWidth(int pw) {
        this.paddleWidth = pw;
    }

    /**
     * @return a string with the level name
     */
    public String levelName() {
        return this.name;
    }

    /**
     *
     * @param n a string containing the level name
     */
    public void setlevelName(String n) {
        this.name = n;
    }

    /**
     * @return the background sprite
     */
    public Sprite getBackground() {
        return this.background;
    }
    /**
     *
     * @param background1 the sprite of the background
     */
    public void setBackground(Sprite background1) {
        this.background = background1;
    }

    /**
     * @return a list with the blocks in the level
     */
    public List<Block> blocks() {
        return this.blocks;
    }
    /**
     * @param block list of blocks idealization
     */
    public void setblocks(List<Block> block) {
        this.blocks = block;
    }
    /**
     * @return the num of blocks in the level
     */
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
    /**
     * @param numOfBlock the num of blocks in the level
     */
    public void setnumberOfBlocksToRemove(int numOfBlock) {
        this.numOfBlocks = numOfBlock;
    }
    /**
     * @return the x point of the block
     */
    public int getBlocksStartX() {
        return this.blocksStartX;
    }
    /**
     * @param blocksStartx set the x point of the block
     */
    public void setBlocksStartX(int blocksStartx) {
        this.blocksStartX = blocksStartx;
    }

    /**
     * @param blocksStarty set the y point of the block
     */
    public void setBlocksStartY(int blocksStarty) {
        this.blocksStartY = blocksStarty;
    }
    /**
     * @return  the y point of the block
     */
    public int getBlocksStartY() {
        return this.blocksStartY;
    }

    /**
     * @return the row height
     */
    public int getRowHeight() {
        return this.rowHeight;
    }

    /**
     * @param rowheight set the row height
     */
    public void setRowHeight(int rowheight) {
        this.rowHeight = rowheight;
    }
}
