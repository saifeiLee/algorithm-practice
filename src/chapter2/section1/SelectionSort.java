package chapter2.section1;

@SuppressWarnings("unchecked")
public class SelectionSort {
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j].compareTo(a[minIndex]) < 0) {
                        minIndex = j;
                }
            }
            Comparable temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
}