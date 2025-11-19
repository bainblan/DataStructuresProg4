
public class Sorter {

    private SortStrategy strategy;

    /**
     * Construct a Sorter with the given strategy.
     *
     * @param strategy the sorting strategy to use
     */
    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Change the sorting strategy used by this Sorter.
     *
     * @param strategy the new sorting strategy
     */
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Sort the provided array using the current strategy.
     *
     * @param array the array to sort
     */
    public void sort(int[] array) {
        strategy.sort(array);
    }
}
