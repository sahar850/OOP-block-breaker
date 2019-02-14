import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Yair on 28/06/2016.
 */

/**
 *
 * @param <T> the T represents the generic type
 */
public class MenuAnimation<T> implements  Menu<T> {
    private boolean stop;
    private T status;
    private List<Selection<T>> menu;
    private List<Selection<Menu<T>>> subMenu;
    private KeyboardSensor keyboardSensor;
    private String title;
    private AnimationRunner ar;

    /**
     * constructor.
     * @param keyboardSensor the key that is pressed
     * @param ar the object that runs the animation
     */
    public MenuAnimation(KeyboardSensor keyboardSensor, AnimationRunner ar) {
        this.menu = new ArrayList<Selection<T>>();
        this.subMenu = new ArrayList<Selection<Menu<T>>>();
        this.keyboardSensor = keyboardSensor;
        this.status = null;
        this.stop = false;
        this.title = "Arkanoid";
        this.ar = ar;
    }

    /**
     *
     * @param d in order to draw any surface we get
     * @param dt get the dt in order to turn the game to be per a second
     */
   public void doOneFrame(DrawSurface d, double dt) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.RED);
        d.drawText(280, 190, this.title, 30);
        d.setColor(Color.BLACK);
        int j = 30;
        for (int i = 0; i < this.subMenu.size(); i++) {
            d.drawText(280, 190 + j, "(" + this.subMenu.get(i).getKey() + ") "
                    + this.subMenu.get(i).getMessage(), 30);
            if (this.keyboardSensor.isPressed(this.subMenu.get(i).getKey())) {
             while (!this.subMenu.get(i).getTask().shouldStop()) {
                 ar.run(this.subMenu.get(i).getTask());
                 if (this.subMenu.get(i).getTask().getStatus() != null) {
                     this.stop = true;
                     this.status = this.subMenu.get(i).getTask().getStatus();
                 }
             }
            }
            j = j + 60;
        }
        for (int i = 0; i < this.menu.size(); i++) {
            d.drawText(280, 190 + j, "(" + this.menu.get(i).getKey() + ") "
                    + this.menu.get(i).getMessage(), 30);
            if (this.keyboardSensor.isPressed(this.menu.get(i).getKey())) {
                this.status = this.menu.get(i).getTask();
                this.stop = true;
            }
            j = j + 60;
        }
    }

    /**
     *
     * @return boolean value
     */
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     *
     * @param reset get the current situation of the animation
     */
    public void setshouldStop(boolean reset) {
        this.stop = reset;
    }

    /**
     *
     * @param key the key that is pressed
     * @param message the text that is shown
     * @param returnVal the method that we want to do
     */
   public void addSelection(String key, String message, T returnVal) {
        this.menu.add(new Selection<T>(key, message, returnVal));
    }

    /**
     *
     * @return the current status of the task
     */
   public T getStatus() {
        return this.status;
    }

    /**
     *
     * @param key the key that is pressed
     * @param message the text that is shown
     * @param submenu the list of the options in the submenu
     */
    public void addSubMenu(String key, String message, Menu<T> submenu) {
        Selection<Menu<T>> selection = new Selection<Menu<T>>(key, message, submenu);
        this.subMenu.add(selection);
    }

    /**
     *
     * @param reset the status of the task
     */
    public void setStatus(T reset) {
        this.status = reset;
    }
}