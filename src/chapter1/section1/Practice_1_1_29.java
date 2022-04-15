package chapter1.section1;

public class Practice_1_1_29 {
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
                while (--mi > 0 && a[mi] == key)
                    ;
                return mi + 1;
            }
        }
        return 0;
    }

    public static int count(int key, int[] a) {
        int countOfSmaller = rank(key, a);
        int i = countOfSmaller;
        int res = 0;
        while (a[i] == key) {
            ++res;
            ++i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 2, 2, 3, 3, 4, 4 };
        int countOfSmaller = rank(3, a);
        System.out.println(countOfSmaller);
        int countOfEqual = count(3, a);
        System.out.println(countOfEqual);
    }
}
