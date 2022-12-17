package Hometask_4;

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
                else {
                    arr[i][j] = rnd.nextInt(4) - 1;
                    if (arr[i][j] > -1)
                        arr[i][j] = 0;
                }
            }
        }
        return arr;
    }

    public static void printField(int[][] array, LinkedList<int[]> way) {
        for (int k = 0; k < way.size(); k++) {
            int[] point = way.get(k);
            array[point[0]][point[1]] = 1;
        }
        int[] pointF = way.getFirst();
        int[] pointS = way.getLast();
        array[pointF[0]][pointF[1]] = -3;
        array[pointS[0]][pointS[1]] = -2;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == -1) {
                    System.out.printf("%c", '\u25A0');
                } else if (array[i][j] == 1) {
                    System.out.printf((char) 27 + "[31m\u25A0" + (char) 27 + "[0m");
                } else if (array[i][j] == -2) {
                    System.out.printf((char) 27 + "[32m\u25A0" + (char) 27 + "[0m");
                } else if (array[i][j] == -3) {
                    System.out.printf((char) 27 + "[34m\u25A0" + (char) 27 + "[0m");
                } else {
                    System.out.printf((char) 27 + "[31m " + (char) 27 + "[0m");
                }
            }
            System.out.println();
        }
    }

    public static void waveAlgorithm(int[][] field, int startX, int startY, int finishX, int finishY) {
        Queue<int[]> quPath = new LinkedList<int[]>();
        field[startX][startY] = 1;
        int[] move = { startX, startY };
        quPath.add(move);
        field[finishX][finishY] = 0;
        while (quPath.size() != 0) {
            move = quPath.remove();
            if (move[0] < field.length - 1) {
                if (field[move[0] + 1][move[1]] == 0) {
                    quPath.add(new int[] { move[0] + 1, move[1] });
                    field[move[0] + 1][move[1]] = field[move[0]][move[1]] + 1;
                }
            }
            if (move[1] < field.length - 1) {
                if (field[move[0]][move[1] + 1] == 0) {
                    quPath.add(new int[] { move[0], move[1] + 1 });
                    field[move[0]][move[1] + 1] = field[move[0]][move[1]] + 1;
                }
            }
            if (move[0] > 0) {
                if (field[move[0] - 1][move[1]] == 0) {
                    quPath.add(new int[] { move[0] - 1, move[1] });
                    field[move[0] - 1][move[1]] = field[move[0]][move[1]] + 1;
                }
            }
            if (move[1] > 0) {
                if (field[move[0]][move[1] - 1] == 0) {
                    quPath.add(new int[] { move[0], move[1] - 1 });
                    field[move[0]][move[1] - 1] = field[move[0]][move[1]] + 1;
                }
            }
        }
    }

    public static LinkedList<int[]> shortestWay(int[][] field, int startX, int startY, int finishX, int finishY) {
        LinkedList<int[]> quPath = new LinkedList<>();
        int[] move = { finishX, finishY };
        quPath.add(move);
        int minValue = field[move[0]][move[1]];
        if (field[finishX][finishY] == 0) {
            return null;
        } else {
            while (move[0] != startX || move[1] != startY) {
                move = quPath.getLast();
                if (move[0] < field.length - 1) {
                    if (field[move[0] + 1][move[1]] < minValue && field[move[0] + 1][move[1]] > 0) {
                        minValue = field[move[0] + 1][move[1]];
                        quPath.add(new int[] { move[0] + 1, move[1] });
                    }
                }
                if (move[1] < field.length - 1) {
                    if (field[move[0]][move[1] + 1] < minValue && field[move[0]][move[1] + 1] > 0) {
                        minValue = field[move[0]][move[1] + 1];
                        quPath.add(new int[] { move[0], move[1] + 1 });
                    }
                }
                if (move[0] > 0) {
                    if (field[move[0] - 1][move[1]] < minValue && field[move[0] - 1][move[1]] > 0) {
                        minValue = field[move[0] - 1][move[1]];
                        quPath.add(new int[] { move[0] - 1, move[1] });
                    }
                }
                if (move[1] > 0) {
                    if (field[move[0]][move[1] - 1] < minValue && field[move[0]][move[1] - 1] > 0) {
                        minValue = field[move[0]][move[1] - 1];
                        quPath.add(new int[] { move[0], move[1] - 1 });
                    }
                }
            }
            quPath.add(new int[] { startX, startY });
            return quPath;
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] myLab = createField(20, 20);
        int xA = 1;
        int yA = 5;
        int xB = 17;
        int yB = 15;
        waveAlgorithm(myLab, xA, yA, xB, yB);
        LinkedList<int[]> myWay = shortestWay(myLab, xA, yA, xB, yB);
        if (myWay == null) {
            System.out.println("No path");
        } else {
            printField(myLab, myWay);
        }
    }
}
