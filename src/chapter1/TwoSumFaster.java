package chapter1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TwoSumFaster {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        int i = 0, j = N - 1;
        while(i < j) {
            if(a[i] + a[j] < 0) {
                i++;
            } else if (a[i] + a[j] > 0) {
                j--;
            } else {
                cnt++;
                i++;
                j--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // int[] a = In.readInts(args[0]);
        // int cnt = count(a);
        // StdOut.println(cnt);
        int[] a = { -1, 0, 1, 2, 4, -4, -2 };
        int cnt = count(a);
        StdOut.println(cnt);
    }
}
