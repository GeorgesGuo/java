import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        while (sc.hasNext()){
            System.out.println("nextInt()方法输出为：");
            int n = sc.nextInt();
            System.out.println(n);
        }
    }
}
