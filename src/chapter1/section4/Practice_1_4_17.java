package chapter1.section4;

import java.util.Arrays;

public class Practice_1_4_17 {
    public static int[] furthestPair(double[] a) {
        int[] result = new int[2];
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < a[minIndex]) {
                minIndex = i;
            } else if (a[i] > a[maxIndex]) {
                maxIndex = i;
            }
        }
        result[0] = minIndex;
        result[1] = maxIndex;
        return result;
    }

    public static void main(String[] args) {
        double[] a = {11.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        int[] result = furthestPair(a);
        System.out.println(Arrays.toString(result));
    }
}
