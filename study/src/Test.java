import java.util.Scanner;

/*
输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数(如'3’，输出：10110011)。
* */
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            jiJiaoYan(str.toCharArray());
        }
    }
    public static void jiJiaoYan(char[]s){
        int [] result = new int [8];
        for (int i = 0; i <s.length ; i++) {
            int n = 0x01;
            int j = 7;
            int sum = 0;
            while (j>0){
                result[j]=(s[i]&n)==0?0:1;
                if(result[j]==1)sum++;
                n<<=1;
                j--;
            }
            if((sum&1)==0)result[0]=1;
            for (int k = 0; k <result.length ; k++) {
                System.out.println(result[k]);

            }
            result[0]=0;
            System.out.println();
        }
    }


}
