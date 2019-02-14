/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
// a BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    /**
     * constructor.
     * @param gameLevel get the current game level
     * @param removedBlocks uses as a counter for the blocks in the game
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
       this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * this method removing the balls from the game if the block with 0 point hit we decrees 1 from the block counter.
     *@param beingHit the block that was been hit
     *@param hitter the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
    if (beingHit.getHitPoints() == 0) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
}
    }

}
