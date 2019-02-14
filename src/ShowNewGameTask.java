import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Yair on 28/06/2016.
 */
public class ShowNewGameTask implements Task<Void> {
    private AnimationRunner runner;
    private File file;
    private HighScoresTable highScoresTable;
    private String path;

    /**
     * constructor.
     * @param runner runs the animation
     * @param file the file with the highscores
     * @param highScoresTable the list of high scores
     * @param path the name of the relevant text file
     * */
    public ShowNewGameTask(AnimationRunner runner, File file,
                           HighScoresTable highScoresTable, String path) {
        this.runner = runner;
        this.file = file;
        this.highScoresTable = highScoresTable;
        this.path = path;
    }

    /**
     * @return null
     */
    public Void run() {
        ArrayList levels = new ArrayList<LevelInformation>();
        InputStreamReader reader = new InputStreamReader(ClassLoader.getSystemClassLoader().
                getResourceAsStream(this.path));
        java.io.BufferedReader lnr = new java.io.BufferedReader(reader);
        GameFlow g = new GameFlow(this.runner, this.runner.getGui().getKeyboardSensor(), 4,
                this.highScoresTable, this.file);
        LevelSpecificationReader lsr = new LevelSpecificationReader();
        try {
            levels = (ArrayList) lsr.fromReader(lnr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        g.runLevels(levels);
        return null;
    }
    }
