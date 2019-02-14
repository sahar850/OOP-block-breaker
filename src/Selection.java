import static javafx.scene.input.KeyCode.T;

/**
 * Created by Yair on 29/06/2016.
 */

/**
 *
 * @param <T> the T represents the generic type
 */
public class Selection<T> {
    private String key;
    private String message;
    private T task;

    /**
     * constructor.
     * @param key the key that is pressed
     * @param message the text that is shown
     * @param task the method that we want to do
     */
    public Selection(String key, String message, T task) {
        this.key = key;
        this.message = message;
        this.task = task;
    }

    /**
     *
     * @return the key that is pressed
     */
    public String getKey() {
        return this.key;
    }

    /**
     *
     * @return the text that is shown
     */
    public String getMessage() {
        return this.message;
    }

    /**
     *
     * @return the method that we want to do
     */
    public T getTask() {
        return this.task;
    }
}