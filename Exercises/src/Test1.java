import java.util.Scanner;

public class Test1 {
    public static boolean isHuiwen(String s){
        int i = 0;
        int j = s.length()-1;
        while (i<j){
            if ( s.charAt(i)!=s.charAt(j) ){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str1 = sc.nextLine();
        System.out.println("请输入添加字符");
        String str2 = sc.nextLine();
        int count=0;
        for (int i = 0; i <= str1.length() ; i++) {
            StringBuilder sb = new StringBuilder(str1);
            sb.insert(i,str2);
            if(isHuiwen(sb.toString())){
                count++;
            }

        }
        System.out.println("构成回文串的方法数为"+count);

    }
}
