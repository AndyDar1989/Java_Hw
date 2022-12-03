package Hometask_3;

public class Ht_3 {

    public static long[] passFromAToB(int a, int b, int c, int d) {
        if (a > b || a == b) {
            return null;
        } else {
            
            long[] step = new long[b-a+1];
           step[0]=1;
            for (int i = 1, x=a+1; i <= b-a; i++, x++) {
                
                
                //if (a * c != i && a + d != i)
                //{step[i] = 0;}
                    
                 if (x-d>=a) {

                    step[i] = step [i - d];
                    

                } if (x % c == 0 && x/c>=a) {
                    step[i] += step[x / c-a];
                    

                }
                
                //System.out.printf("%s ", step[i]);

            }
            return step;
        }
    }

    /*a: 2 b: 7 c: 2 d: 1 -> 3
a: 3 b: 27 c: 3 d: 2 -> 6
a: 30 b: 345 c: 5 d: 6 -> 0
a: 30 b: 345 c: 2 d: 1 -> 7047
a: 22 b: 333 c: 3 d: 1 -> 467
a: 55 b: 555 c: 5 d: 2 -> 30
a: 22 b: 2022 c: 11 d: 56 -> 0
a: 22 b: 2022 c: 11 d: 10 -> 18
a: 22 b: 2022 c: 3 d: 1 -> 763827
a: 22 b: 20220 c: 3 d: 1 -> 535173226980
a: 1 b: 1111 c: 2 d: 1 -> 3990330794
a: 1 b: 11111 c: 2 d: 1 -> 606408167570737286*/

    public static void main(String[] args) {
        long[] res = passFromAToB(1, 11111, 2, 1);
        
        System.out.println(res[res.length-1]);

    }

}
