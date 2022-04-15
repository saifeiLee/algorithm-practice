package chapter1.section4;

import java.util.Arrays;

public class Practice_1_4_16 {
    public static int[] closestPair(double[] a) {
        int[] result = new int[2];
        double currentMiniumDifference = Double.MAX_VALUE;
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (Math.abs(a[i + 1] - a[i]) < currentMiniumDifference) {
                currentMiniumDifference = Math.abs(a[i + 1] - a[i]);
                result[0] = i;
                result[1] = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        double[] a = {11.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        int[] result = closestPair(a);
        System.out.println(Arrays.toString(result));
    }
}
