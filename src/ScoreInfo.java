/**
 * Created by Sahar on 02/06/2016.
 */
public class ScoreInfo implements java.io.Serializable {
    private String name;
    private int score;

    /**
     * constructor.
     * @param name name of the player
     * @param score score of the player
     */
    public ScoreInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     *
     * @return the name of the player
     */
    public String getName() {
       return this.name;
    }

    /**
     *
     * @return the score of the player
     */
    public int getScore() {
        return this.score;
    }
}
