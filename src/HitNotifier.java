/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public interface HitNotifier {
    /**
     * @param hl Add hl as a listener to hit events.
     */
    void addHitListener(HitListener hl);
    /**
     * @param hl Remove hl from the list of listeners to hit events.
     */
    void removeHitListener(HitListener hl);
}