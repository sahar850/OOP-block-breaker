/**
 * Created by Yair on 28/06/2016.
 */

/**
 *
 * @param <T> the T represents the generic type
 */
public interface Task<T> {
    /**
     *
     * @return the status
     */
    T run();
}
