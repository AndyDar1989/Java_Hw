import java.util.Random;

public class Merge_sort {
    public static int[] createArray(int size, int min, int max){
        int[] newArray = new int[size];
        Random random = new Random();
        int diff = max-min;
        for (int i = 0; i < size; i++) {
            newArray[i] = random.nextInt(diff+1)-max;
            //System.out.printf("%s ", newArray[i]);
            
        }
        return newArray;
    }
    
    public static String printArray(int[] array){
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += array[i]+" ";
            
        }
        return result;

    }


    public static void divArr(int[] array) {

        while(array.length>1){
        int [] divA = new int[array.length/2];
        int [] divB = new int[array.length/2];
        
        for (int i = 0; i < array.length/2; i++) {
            divA[i]=array[i];
        }
        for (int i = array.length/2; i < array.length; i++) {
            divB[i]=array[i];
            
        }

        divArr(divA);
        divArr(divB);}

    }

    public static void mergeArray(int [] arrayA,int [] arrayB){
        int[] sortedArray = new int[arrayA.length+arrayB.length];
        for (int i = 0; i < sortedArray.length; i++) {
            if (arrayA[i]<arrayB[i]){sortedArray[i]=arrayA[i];}
            else{sortedArray[i]=arrayB[i];}
            
        }


    }
    public static void main(String[] args) {
        int[]myArr = createArray(10, -10, 10);
        System.out.println(printArray(myArr));
        
    }
    
}
