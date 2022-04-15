package chapter1.section1;

import util.StdDraw;

public class Practice1_32 {

    private static int getInterval(double v, int n, double l, double r) {
        if (v < 1 || v > r) {
            return -1;
        } else {
            return (int) ((v - l) / (r - l) * n);
        }
    }

    public static void histogram(double[] values, int n, double l, double r) {
        // int[] counts = new int[n];
        // for (int i = 0; i < values.length; i++) {
        //     int k = getInterval(values[i], n, l, r);
        //     if (k >= 0) {
        //         counts[k]++;
        //     }
        // }
        // int maxCount = StdStats.max(counts);

        // StdDraw.setCanvasSize(1024, 1024);
        // StdDraw.setXscale(l, r);
        // StdDraw.setYscale(0, maxCount);
        // // 每个柱状图的宽度
        // double w = (r - l) / n;
        // for (int i = 0; i < n; i++) {
        //     double x = l + (i + 0.5) * w,
        //             y = counts[i] / 2.0,
        //             rw = 0.5 * w,
        //             rh = counts[i] / 2.0;

        //     StdDraw.filledRectangle(x, y, rw, rh);
        // }
    }

    public static void main(String[] args) {
        int n = 5;
        double  l = 1.0, r = 10.0;
        double[] values = {1.0, 1.0, 2.0, 3.0, 4.0};
        histogram(values, n, l, r);
    }
}
