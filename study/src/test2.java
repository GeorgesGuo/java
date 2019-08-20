/*对N个长度最长可达到1000的数进行排序。*/


import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            BigInteger[]bd = new BigInteger[n];
            for (int i = 0; i <n ; i++) {
                bd[i]=sc.nextBigInteger();
                Arrays.sort(bd);
                for (int j = 0; j <n ; j++) {
                    System.out.println(bd[i]);
                }
            }
        }
    }


}
