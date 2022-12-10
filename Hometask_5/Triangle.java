package Hometask_5;

import java.util.Scanner;

public class Triangle {

    public static int getNumber() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Enter number N:  ");
        int num = iScanner.nextInt();
        iScanner.close();
        return num;
    }

    public static String[] TriangleNum(int number) {
        int result = number * (number + 1) / 2;
        String[] res = new String[number + 1];
        res[0] = "Triangular number from N:";
        res[1] = "1";
        for (int i = 2; i <= number; i++) {
            res[i] = res[i - 1] + "+" + i;
        }
        res[res.length - 1] += " = " + result;

        return res;
    }

    public static void printRes(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int myNum = getNumber();
        String[] myRes = TriangleNum(myNum);
        printRes(myRes);
    }
}
