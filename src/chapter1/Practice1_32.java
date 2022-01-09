package chapter1;

import edu.princeton.cs.algs4.StdStats;

public class Practice1_32 {

    private static int getInterval(double v, int n, double l, double r) {
        if (v < 1 || v > r) {
            return -1;
        } else {
            return (int) ((v - l) / (r - l) * n);
        }
    }

    public static void main(String[] args) {

    }
}
