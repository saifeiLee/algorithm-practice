package chapter1;

public class Gcd {
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int ret = p % q;
        return gcd(q, ret);
    }

    public static void main(String[] args) {
        int test = gcd(10, 20);
        System.out.println(test);
    }
}
