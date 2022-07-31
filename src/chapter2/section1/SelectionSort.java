package chapter2.section1;

@SuppressWarnings("unchecked")
public class SelectionSort extends Example {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            Comparable temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
}