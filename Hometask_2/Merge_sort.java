import java.util.Arrays;
import java.util.Random;

public class Merge_sort {
    public static int[] createArray(int size, int min, int max) {
        int[] newArray = new int[size];
        Random random = new Random();
        int diff = max - min;
        for (int i = 0; i < size; i++) {
            newArray[i] = random.nextInt(diff + 1) - max;
            // System.out.printf("%s ", newArray[i]);

        }
        return newArray;
    }

    public static String printArray(int[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i] + " ";

        }
        return result;

    }

    public static int[] divArr(int[] array) {
        if (array == null) {
            return null;
        }
        if (array.length < 2) {
            return array;
        }
        int size = array.length / 2;
        int[] divA = new int[size];
        System.arraycopy(array, 0, divA, 0, size);
        int[] divB = new int[array.length - size];
        System.arraycopy(array, size, divB, 0, array.length - size);


        divA = divArr(divA);

        divB = divArr(divB);

        
        return mergeArray(divA, divB);

    }

    public static int[] mergeArray(int[] arrayA, int[] arrayB) {
        int[] sortedArray = new int[arrayA.length + arrayB.length];
        int posA = 0;
        int posB = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (posA > arrayA.length-1) {
                int a = arrayB[posB];
                sortedArray[i] = a;
                posB++;
            } else if (posB > arrayB.length-1) {
                int a = arrayA[posA];
                sortedArray[i] = a;
                posA++;
            } else if (arrayA[posA] < arrayB[posB]) {
                int a = arrayA[posA];
                sortedArray[i] = a;
                posA++;
            } else {
                int b = arrayB[posB];
                sortedArray[i] = b;
                posB++;
            }

        }

        return sortedArray;

    }

    public static void main(String[] args) {
        int[] myArr = createArray(10, -10, 10);
        System.out.println(printArray(myArr));
        int[] mySort = divArr(myArr);
        System.out.println(printArray(mySort));

    }

}
