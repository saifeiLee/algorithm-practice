package chapter2.section3;

import chapter2.section1.Example;
import edu.princeton.cs.algs4.StdRandom;

public class Quick extends Example {
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void quickSort(Comparable[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = partition(array, low, high);
        quickSort(array, low, partition - 1);
        quickSort(array, partition + 1, high);
    }

    public static void quickSort(Comparable[] array) {
        StdRandom.shuffle(array);
        quickSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        Integer[] arr = { 3, 2, 1, 6, 9 };
        // Quick q = new Quick();
        Quick.quickSort(arr);
        for (Integer x: arr) {
            System.out.println(x);
        }
    }
}
