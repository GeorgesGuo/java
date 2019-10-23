import java.util.Scanner;

public class Main {
    public static String toChar(String a,String b){
        char []aArray = a.toCharArray();
        char []bArray = b.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <aArray.length ; i++) {
                stringBuffer.append(aArray[i]);
                if(i%4==0) {
                    stringBuffer.append(bArray[1]);
                }else if(i*4>aArray.length){
                stringBuffer.insert(stringBuffer.length(),bArray);
                }
        }
        return stringBuffer.toString();
    }

    public static String merge (String a,String b){
        char[]aChar = a.toCharArray();
        char[]bChar = b.toCharArray();
         int Length = aChar.length+bChar.length;
         char []mixChar =new char[Length];
         for (int i = 0; i <aChar.length ; i++) {
            for (int j = i+3; j <aChar.length ; j++) {
                mixChar[i*2] =aChar[i];
                mixChar[i*2+3]=bChar[i];
                if (i*4>aChar.length){
                    mixChar[i] = bChar[j];
                }
            }
         }
        return String.valueOf(mixChar);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
     // System.out.println(merge(a,b));

        System.out.println(toChar(a,b));
    }
}


