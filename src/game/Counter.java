package game;

/**
 * The type game.Counter.
 * Count the remaining objects of some type.
 */
public class Counter {
    private int counter = 0;


    /**
     * Increase.
     * add number to current count.
     *
     * @param number the number who the method add to the current count.
     */
    public void increase(int number) {
        counter += number;
    }

    /**
     * Decrease.
     * subtract number from current count.
     *
     * @param number the number who the method substract to the current count.
     */
    public void decrease(int number) {
        counter -= number;
    }

    /**
     * Get the current count.
     *
     * @return the int - current count.
     */

    public int getValue() {
        return counter;
    }
}