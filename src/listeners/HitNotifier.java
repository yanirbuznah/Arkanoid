package listeners;

/**
 * The interface Hit notifier.
 *  Indicate that objects that implement it send notifications when they are being hit.
 */
public interface HitNotifier {
    /**
     * Add hit listener to hit events.
     *
     * @param hl the hit listener.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hit listener from the list of listeners to hit events.
     *
     * @param hl the hit listener.
     */
    void removeHitListener(HitListener hl);
}