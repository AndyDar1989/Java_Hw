package Hometask_1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class input {

    public static List<String> readFile(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        List<String> newList = new LinkedList<>();
        String str;
        while ((str = br.readLine()) != null) {
            newList.add(str);
        }
        return newList;
    }

    public static int[] getNumbers(List<String> data) {
        int[] newArr = new int[2];
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).contains("b")) {
                String b = data.get(i);
                String[] numB = b.split(" ");
                int numb = Integer.parseInt(numB[1]);
                System.out.println(numb);
                newArr[0] = numb;
            } else if (data.get(i).contains("a")) {
                String a = data.get(i);
                String[] numA = a.split(" ");
                int numa = Integer.parseInt(numA[1]);
                System.out.println(numa);
                newArr[1] = numa;
            }
        }
        return newArr;
    }

    public static double powNum(int[] array) throws Exception {
        if (array[1] == 0 && array[0] == 0)
            return -1;
        else {
            double res = Math.pow(array[1], array[0]);
            return res;
        }
    }

    public static void resultWriter(String path, double result) throws Exception {
        try (FileWriter fr = new FileWriter(path, false)) {
            if (result == -1) {
                fr.write("function not defined");
                fr.flush();
            } else {
                fr.write(String.valueOf(result));
                fr.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> myList = readFile("input.txt");
        int[] myArr = getNumbers(myList);
        double myRes = powNum(myArr);
        System.out.println(myRes);
        resultWriter("output.txt", myRes);
    }
}
