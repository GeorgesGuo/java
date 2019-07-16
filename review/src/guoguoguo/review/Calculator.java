package guoguoguo.review;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.scene.chart.NumberAxis;

import javax.xml.transform.Result;
import java.util.Scanner;

import static javax.print.attribute.standard.MediaSizeName.A;

class Add extends Operation{
    @Override
    public double GetResult(int A,int B) {
        double result =0;
        result = A+B;
        return result;
    }
}
class Sub extends Operation{
    @Override
    public double GetResult(int A,int B) {
        double result = 0;
        result = A-B;
        return result;
    }
}
class Mul extends Operation{
    @Override
    public double GetResult(int A,int B) {
        double result =0;
        result = A*B;
        return result;
    }
}
class Div extends Operation{
    @Override
    public double GetResult(int A,int B) {
        double result = 0;
        result = A/B;
        return result;
    }
}


public class Calculator extends Operation {

    public static void main(String[] args) {
        String Result = "";
        Operation oper = null;

        System.out.println("请输入数字A：");
        Scanner NumA = new Scanner(System.in);

        int A = NumA.nextInt();
        System.out.println("请输入运算符号：");
        Scanner Operate =new Scanner(System.in);
        String Ope = Operate.nextLine();
        System.out.println("请输入数字B：");
        Scanner NumB =new Scanner(System.in);
        int B = NumB.nextInt();

        if(Ope.equals("+")){
           oper = new Add();
            System.out.println("结果是："+ oper.GetResult(A,B));

        }if(Ope.equals("-")){
           oper = new Sub();
            System.out.println("结果是："+oper.GetResult(A,B));
        }if(Ope.equals("*")){
           oper = new Mul();
            System.out.println("结果是："+oper.GetResult(A,B));
        }if(Ope.equals("/")) {
            oper = new Div();
            if ( B == 0 ) {
                throw new IllegalArgumentException("除数不能为0!");
            } else {
                System.out.println("结果是："+oper.GetResult(A,B));
            }
        }
    }
}
