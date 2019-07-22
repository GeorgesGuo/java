import java.util.Scanner;

public class Test4 {
    public static int drink(int n){
        int total = 0;
        while (n>2){
            total = total+n/3;
            n = n/3+n%3;
        }
        if(n==2){
            total =total+1;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("请输入瓶子数量：");
        while (sc.hasNext()){
            System.out.println("最多可以喝的汽水数：");
             n = sc.nextInt();
            System.out.println(drink(n));
        }
    }


}
