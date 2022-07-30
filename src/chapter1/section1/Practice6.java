package chapter1.section1;

// 返回string 的reverse版本，挺牛逼的
public class Practice6 {
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N/ 2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        String s = "abcd";
        String res = mystery(s);
        System.out.println(res);
    }
}
