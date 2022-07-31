package chapter2.section1;

public class ShellSort {
    @SuppressWarnings("unchecked")
    public static void shellSort(ComparableBase[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(array[j], array[j - 1]); j -= h) {
                    exch(array, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
