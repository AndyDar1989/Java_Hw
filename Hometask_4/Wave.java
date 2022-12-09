package Hometask_4;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;



public class Wave {
    

    public static int[][] createField(int a, int b) {
        int[][] arr = new int[a][b];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 0 || j == 0 || i == a - 1 || j == b - 1)
                    arr[i][j] = -1;
                else{
                    arr[i][j] = rnd.nextInt(4)-1;
                if (arr[i][j]>-1)
                arr[i][j]=0;}  
            }
        }
        return arr;
    }

    public static void writeField(String path, int[][]arr) throws Exception{
        try(FileWriter fr = new FileWriter(path, false)){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    fr.write(String.valueOf(arr[i][j]));
                    fr.flush();
                }
            fr.write('\n');}}


        catch (IOException ex) {
            System.out.println(ex.getMessage());}

    }

    public static void printArray(int[][] array) {
        char ch = '\u275A';
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i][j]==-1){
                System.out.printf("%c",'\u25A0');}
                else{
                    
                System.out.printf((char) 27 + "[31m "+ (char) 27 + "[0m");}
            }
            System.out.print("\n");

        }

    }

    public static void printArrayN(int[][] array) {
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                
                System.out.print(array[i][j]);}
                
            
            System.out.println();}}

    public static void startEndPositions(int[][] map, int startX, int startY, int finishX, int finishY) {
        Queue<int[]> quPath = new LinkedList<int[]>();
        int[][]field = map;
        int i = startX;
        int j = startY;
        field[i][j] =1;
        int[] move= {i,j};
        quPath.add(move); 
        field[finishX][finishY] =0; 
        
        while (quPath.size()!=0) {
            move =  quPath.remove();

            if (field[move[0] + 1][move[1]] == 0) {
                
                quPath.add(new int [] {move[0] + 1,move[1]});
                field[move[0]+1][move[1]] =field[move[0]][move[1]]+ 1;
                
                
                
            }
            if (field[move[0]][move[1]+1] == 0) {
               
                quPath.add(new int [] {move[0],move[1]+1});
                
                field[move[0]][move[1]+1] =field[move[0]][move[1]]+ 1;
               
                
            }
            if (field[move[0]-1][move[1]] == 0) {
                
                quPath.add(new int [] {move[0]-1,move[1]});
                
                field[move[0]-1][move[1]] =field[move[0]][move[1]]+ 1;
                
                
                
            }
            if (field[move[0]][move[1]-1] == 0) {
                
                quPath.add(new int [] {move[0],move[1]-1});
               
                field[move[0]][move[1]-1] =field[move[0]][move[1]]+ 1;
                
               
                }
            
            
            
        }
        printArrayN(field);

    }

    public static void shortestWay(int[][]array,int startX, int startY, int finishX, int finishY){
        

    }

    public static void main(String[] args) throws Exception{
        int[][] myLab = createField(10, 10);
        printArray(myLab);
        
        startEndPositions(myLab, 1, 1, 7, 7);
        //printArrayN(myPath);
        
        
            
        

    }

}
