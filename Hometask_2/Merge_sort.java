import java.util.Arrays;
import java.util.Random;

public class Merge_sort {
    public static int[] createArray(int size, int min, int max) {
        int[] newArray = new int[size];
        Random random = new Random();
        int diff = max - min;
        for (int i = 0; i < size; i++) {
            newArray[i] = random.nextInt(diff + 1) + min;
        }
        return newArray;
    }

    public static String printArray(int[] array) {
        String result = "[";
        for (int i = 0; i < array.length - 1; i++) {
            result += array[i] + ", ";
        }
        result += array[array.length - 1] + "]";
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
        int[] divA = Arrays.copyOfRange(array, 0, size);
        int[] divB = Arrays.copyOfRange(array, size, array.length);
        divA = divArr(divA);
        divB = divArr(divB);

        return mergeArray(divA, divB);

    }

    public static int[] mergeArray(int[] arrayA, int[] arrayB) {
        int[] sortedArray = new int[arrayA.length + arrayB.length];
        int posA = 0;
        int posB = 0;
        for (int i = 0; i < sortedArray.length; i++) {
            if (posA > arrayA.length - 1) {
                sortedArray[i] = arrayB[posB];
                posB++;
            } else if (posB > arrayB.length - 1) {
                sortedArray[i] = arrayA[posA];
                posA++;
            } else if (arrayA[posA] < arrayB[posB]) {
                sortedArray[i] = arrayA[posA];
                posA++;
            } else {
                sortedArray[i] = arrayB[posB];
                posB++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] myArr = createArray(20, -15, 45);
        System.out.println(printArray(myArr));
        int[] mySort = divArr(myArr);
        System.out.println(printArray(mySort));
    }
}
