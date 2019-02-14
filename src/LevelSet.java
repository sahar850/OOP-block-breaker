import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <T> use generic to set the sub menu
 */
public class LevelSet<T> implements Animation, Menu<T> {
    private boolean stop;
    private T status;
    private List<Selection<T>> subMenu;
    private KeyboardSensor keyboardSensor;

    /**
     * @param keyboardSensor the keyboarder sensor to indicants what was pressed
     */
    public LevelSet(KeyboardSensor keyboardSensor) {
        this.keyboardSensor = keyboardSensor;
        this.status = null;
        this.stop = false;
        this.subMenu = new ArrayList<>();
    }
    /**
     * @param d  in order to draw any surface we get
     * @param dt num to make the program run per sec
     */
    public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.RED);
        d.drawText(280, 190, "Choose a game", 30);
        d.setColor(Color.BLACK);
        int j = 30;
        for (int i = 0; i < this.subMenu.size(); i++) {
            d.drawText(280, 190 + j, "(" + this.subMenu.get(i).getKey() + ") "
                    + this.subMenu.get(i).getMessage(), 30);
            j = j + 60;
        }
        for (int i = 0; i < this.subMenu.size(); i++) {
            if (this.keyboardSensor.isPressed(this.subMenu.get(i).getKey())) {
                this.status = this.subMenu.get(i).getTask();
                this.stop = true;
            }
        }
    }

    /**
     * @return if should or should't stop
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * @param key the key for the selection
     * @param message the message to display
     * @param returnVal the return value of the selection
     */
    public void addSelection(String key, String message, T returnVal) {
        this.subMenu.add(new Selection<T>(key, message, returnVal));
    }

    /**
     * @return the selected status
     */
    public T getStatus() {
        return this.status;
    }
    /**
     * function not used in this class.
     * @param key .
     * @param message .
     * @param subMenu1 .
     */
    public void addSubMenu(String key, String message, Menu<T> subMenu1) {
    }
    @Override
    public void setStatus(T reset) {
        this.status = reset;
    }

    @Override
    public void setshouldStop(boolean reset) {
         this.stop = reset;
    }
}