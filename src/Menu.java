import static javafx.scene.input.KeyCode.T;

/**
 * Created by Yair on 28/06/2016.
 */

/**
 *
 * @param <T> the T represents the generic type
 */
public interface Menu<T> extends Animation {
    /**
     *
     * @param key the key that is pressed
     * @param message the text that is shown
     * @param returnVal the method that we want to do
     */
    void addSelection(String key, String message, T returnVal);

    /**
     *
     * @return the current status of the task
     */
    T getStatus();

    /**
     *
     * @param key the key that is pressed
     * @param message the text that is shown
     * @param subMenu the list of the options in the submenu
     */
    void addSubMenu(String key, String message, Menu<T> subMenu);

    /**
     *
     * @param o the status of the task
     */
    void setStatus(T o);

    /**
     *
     * @param b get the current situation of the animation
     */
    void setshouldStop(boolean b);
}
