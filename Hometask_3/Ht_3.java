package Hometask_3;

import java.io.IOException;

public class Ht_3 {
    public static long passFromAToB(int a, int b, int c, int d) throws Exception {
        if (a >= b)
            return 0;
        else {
            long[] steps = new long[b - a + 1];
            steps[0] = 1;
            for (int i = 1, x = a + 1; i <= b - a; i++, x++) {
                if (x - d >= a)
                    steps[i] = steps[i - d];
                if (x % c == 0 && x / c >= a)
                    steps[i] += steps[x / c - a];
            }
            return steps[steps.length - 1];
        }
    }

    public static String showPath(int a, int b, int c, int d) {
        int x = b;
        String path = "";
        while (x > a) {
            if (x / c >= a && x % c == 0) {
                path += "1";
                x = x / c;
            } else {
                path += "2";
                x = x - d;
            }
        }
        path = reverseString(path);
        path += b;
        return path;
    }

    public static String reverseString(String str) {
        String revStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '1')
                revStr += "k1->";
            else
                revStr += "k2->";
        }
        return revStr;
    }

    public static void printResult(long num, String commands) {
        if (num == 0)
            System.out.println("No paths");
        else {
            System.out.printf("Total number of conversion paths - %s", num);
            System.out.println();
            System.out.printf("The best route is %s", commands);
        }
    }

    public static void main(String[] args) throws Exception {
        long res = passFromAToB(1, 11111, 2, 1);
        String com = showPath(1, 11111, 2, 1);
        printResult(res, com);
    }
}
