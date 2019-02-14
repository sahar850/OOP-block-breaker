import biuoop.DialogManager;
import biuoop.KeyboardSensor;
import java.io.File;
import java.io.IOException;
import java.util.List;
/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class GameFlow {
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private Counter scoreCounter;
    private Counter livesCounter;
    private int lives;
    private HighScoresTable highScoresTable;
    private File file;

    /**
     * constractor.
     * @param ar the animation runner of the game
     * @param ks the Keyboard Sensor of the game
     * @param lives the initialize number of live
     * @param highScoresTable  an high score table
     * @param file the file for the high score
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, int lives, HighScoresTable highScoresTable, File file) {
        this.runner = ar;
        this.keyboard = ks;
        this.lives = lives;
        this.scoreCounter = new Counter(0);
        this.livesCounter = new Counter(this.lives);
        this.highScoresTable = highScoresTable;
        this.file = file;

      }

    /**
     * this methon runs the games levels.
     * @param levels lhe list of levels in the courrent game
     */
    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo,
                    this.keyboard, this.runner, this.scoreCounter, this.livesCounter);
            level.initialize();
            LivesIndicator livesIndicator = new LivesIndicator(this.livesCounter);
            ScoreIndicator scoreIndicator = new ScoreIndicator(this.scoreCounter);
            LevelNameIndicator levelNameIndicator = new LevelNameIndicator(levelInfo.levelName());
            level.addSprite(livesIndicator);
            level.addSprite(scoreIndicator);
            level.addSprite(levelNameIndicator);
            while (level.getblockcounter().getValue() > 0 && this.livesCounter.getValue() > 0) {
                level.playOneTurn();
                if (level.getBallCounter().getValue() == 0) {
                    this.livesCounter.decrease(1);
                }
            }
            if (level.getblockcounter().getValue() == 0) {
                this.scoreCounter.increase(100);
            }
            if (this.livesCounter.getValue() == 0) {
                this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                        KeyboardSensor.SPACE_KEY, new LooseScreen(this.scoreCounter)));
                if (highScoresTable.getRank(scoreCounter.getValue()) < highScoresTable.size()) {
                    DialogManager dialog = this.runner.getGui().getDialogManager();
                    String name = dialog.showQuestionDialog("Name", "What is your name?", "");
                    System.out.println(name);
                    ScoreInfo s = new ScoreInfo(name, scoreCounter.getValue());
                    highScoresTable.add(s);
                    try {
                        highScoresTable.save(this.file);
                    } catch (IOException e) {
                        System.out.print("cant save file");
                    }
                }
                this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                        KeyboardSensor.SPACE_KEY, new HighScoresAnimation(highScoresTable)));
                break;
            }
        }
        if (this.livesCounter.getValue() != 0) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "space", new WinScreen(this.scoreCounter)));
            if (highScoresTable.getRank(scoreCounter.getValue()) < highScoresTable.size()) {
                DialogManager dialog = this.runner.getGui().getDialogManager();
                String name = dialog.showQuestionDialog("Name", "What is your name?", "");
                System.out.println(name);
                ScoreInfo s = new ScoreInfo(name, scoreCounter.getValue());
                highScoresTable.add(s);
                try {
                    highScoresTable.save(this.file);
                } catch (IOException e) {
                    System.out.print("cant save file");
                }
            }
        }
        this.runner.run(new KeyPressStoppableAnimation(this.keyboard,
                KeyboardSensor.SPACE_KEY, new HighScoresAnimation(highScoresTable)));
    }
}

