/**
 * @author Yair Frank, 203699566
 * @author Sahar Levi, 203405147
 */
public class Counter {
    private int value;
    /**
     * constractor.
     * @param firstValue the counter first value
     */
    public Counter(int firstValue) {
        this.value = firstValue;
    }
    /**
     * @param number a number to add to the current counter value
     */
   public void increase(int number) {
        this.value = this.value + number;
    }
    /**
     * @param number a number to substreact to the current counter value
     */
    public void decrease(int number) {
        this.value = this.value - number;
    }
    /**
     * @return current count value.
      */
    public int getValue() {
        return this.value;
    }

}