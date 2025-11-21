/**
 * Strategy interface for sorting algorithms. Implementations should perform
 * an in-place sort of the provided array and report the number of element
 * comparisons performed via {@link #getComparisons()}.
 */
public interface SortStrategy {

    /**
     * Sorts the provided array in-place.
     *
     * @param array the array to sort
     */
    void sort(int[] array);

    /**
     * Returns the number of element comparisons performed by the last sort.
     *
     * @return comparison count
     */
    public long getComparisons();
}
