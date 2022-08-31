package chapter1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
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
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
        // int[] whitelist = { 6, 4, 3, 2, 1 };
        // Arrays.sort(whitelist);
        // System.out.println("排序后:");
        // for (int num : whitelist) {
        // System.out.print(num);
        // System.out.print(" ");
        // }
        // System.out.println();
        // int result = BinarySearch.rank(2, whitelist);
        // System.out.println(result);
    }
}