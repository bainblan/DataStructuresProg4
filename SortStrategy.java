
public interface SortStrategy {
    /**
     * Sort the given array in-place according to the strategy.
     *
     * @param array the array to sort
     */
    void sort(int[] array);

    public long getComparisons();
}
