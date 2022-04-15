
package chapter1.section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import util.In;
import util.StdIn;
import util.StdOut;

public class Practice_1_1_28 {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mi = (lo + hi) / 2;
            if (key < a[mi]) {
                hi = mi - 1;
            } else if (key > a[mi]) {
                lo = mi + 1;
            } else {
                return mi;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        System.out.println(args[0]);
        System.out.println(Arrays.toString(whitelist));
        int len = whitelist.length;
        int[] arr = new int[len];
        int indexOfArr = 0;
        arr[indexOfArr] = whitelist[0];
        for (int i = 1; i < len; ++i) {
            if (arr[indexOfArr] != whitelist[i]) {
                arr[++indexOfArr] = whitelist[i];
            }
        }
        System.out.println(Arrays.toString(arr));
        // while (!StdIn.isEmpty()) {
        // int key = StdIn.readInt();
        // if (rank(key, whitelist) < 0) {
        // StdOut.println(key);
        // }
        // }
    }
}
