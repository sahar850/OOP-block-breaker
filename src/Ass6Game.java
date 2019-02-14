import biuoop.GUI;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class Ass6Game {
    /**
     * this is the main of the program, who runs the game.
     *
     * @param args get a string containing the number of level to run.
     */
    public static void main(String[] args) {
        File file = new File("highscores");
        HighScoresTable highScoresTable = HighScoresTable.loadFromFile(file);
        AnimationRunner ar = new AnimationRunner(new GUI("Ass6Game", 800, 600));
        InputStreamReader levelsSets = new InputStreamReader(ClassLoader.getSystemClassLoader().
                getResourceAsStream("level_sets.txt"));
        BufferedReader lnr = new BufferedReader(levelsSets);
        String line = null;
        ShowNewGameTask easy = null;
        ShowNewGameTask hard = null;
        ShowNewGameTask special = null;
        try {
            line = lnr.readLine();
        } catch (Exception e) {
            System.out.println("cannot read level sets file");
        }
        while (line != null) {

            if (line.startsWith("e:")) {
                try {
                    line = lnr.readLine();
                } catch (Exception e) {
                    System.out.println("cannot read level sets file");
                }
                easy = new ShowNewGameTask(ar, file, highScoresTable, line);
            }
            if (line.startsWith("h:")) {
                try {
                    line = lnr.readLine();
                } catch (Exception e) {
                    System.out.println("cannot read level sets file");
                }
                hard = new ShowNewGameTask(ar, file, highScoresTable, line);
            }
            if (line.startsWith("s:")) {
                try {
                    line = lnr.readLine();
                } catch (Exception e) {
                    System.out.println("cannot read level sets file");
                }
                special = new ShowNewGameTask(ar, file, highScoresTable, line);
            }
            try {
                line = lnr.readLine();
            } catch (Exception e) {
                System.out.println("cannot read level sets file");
            }

        }
        Menu<Task<Void>> menu = new MenuAnimation<Task<Void>>(ar.getGui().getKeyboardSensor(), ar);
        Menu<Task<Void>> submenu = new LevelSet<Task<Void>>(ar.getGui().getKeyboardSensor());
        submenu.addSelection("e", "Easy", easy);
        submenu.addSelection("s", "Special", special);
        submenu.addSelection("h", "Hard", hard);
        menu.addSelection("l", "High scores", new ShowHiScoresTask(ar, new HighScoresAnimation(highScoresTable),
                ar.getGui().getKeyboardSensor()));
        menu.addSubMenu("g", "Play game", submenu);
        menu.addSelection("q", "Quit", new ShowQuitTask(ar));

        while (true) {

            ar.run(menu);
            Task<Void> task = menu.getStatus();
            task.run();
            menu.setStatus(null);
            submenu.setStatus(null);
            menu.setshouldStop(false);
            submenu.setshouldStop(false);

        }
    }
}





