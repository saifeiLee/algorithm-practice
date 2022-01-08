package chapter1;

/**
 * <Algorithm> 4th ed. 1.1.26练习题
 */
public class Practice_1_1_26 {
    static int count = 0;

    public static double binomial(int N, int k, double p) {
        count++;
        System.out.println(count);
        if (N == 0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static double binomial2Start(int N, int k, double p) {
        double[][] arr = new double[N + 1][k + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }
        return binomial2(arr, N, k, p);
    }

    public static double binomial2(double[][] arr, int N, int k, double p) {
        count++;
        System.out.println(count);
        if (N == 0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        if (arr[N][k] == -1) {
            arr[N][k] = (1.0 - p) * binomial2(arr, N - 1, k, p) + p * binomial2(arr, N - 1, k - 1, p);
        }
        return arr[N][k];
    }

    public static void main(String[] args) {
        // System.out.println(12);
        double res1 = binomial(100, 50, 0.25);
        // double res1 = binomial2Start(100, 50, 0.25);
        System.out.println(res1);
    }
}
