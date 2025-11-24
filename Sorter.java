/**
 * Simple context class that holds a {@link SortStrategy} and delegates sorting.
 */
public class Sorter {

    private SortStrategy strategy;

    /**
     * Creates a Sorter with the given strategy.
     *
     * @param strategy initial sorting strategy
     */
    public Sorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Replaces the current sorting strategy.
     *
     * @param strategy new sorting strategy
     */
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Delegates sorting to the configured strategy.
     *
     * @param array array to sort
     */
    public void sort(int[] array) {
        strategy.sort(array);
    }
}
