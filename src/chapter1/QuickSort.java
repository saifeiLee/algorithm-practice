package chapter1;

public class QuickSort {
    public static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mi = partition(a, lo, hi);
        quickSort(a, lo, mi - 1);
        quickSort(a, mi + 1, hi);
    }

    public static int partition(int[] a, int lo, int hi) {
        int key = a[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (a[++i] < key) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > key) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
