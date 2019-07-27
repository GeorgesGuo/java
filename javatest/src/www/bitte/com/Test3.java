package www.bitte.com;
/*3.按如下要求编写Java程序：
        （1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
        （2）定义接口B，里面包含抽象方法void setColor(String c)。
        （3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
        （4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
        圆柱体的高height、颜色color。
        （5）创建主类来测试类Cylinder。*/

import java.util.concurrent.Callable;

interface A{
    double PI=3.14;
     double area ();
}
interface B{
     void setColor(String c);

}
interface C extends B,A{
     void volume();
}
class Cylinder implements C{

    @Override
    public void volume() {

    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public void setColor(String c) {

    }

    private double radius;
    double r=radius;
    private double height;
   double h = height;
   private String color;
   String c = color;


}
public class Test3 {
    public static void main(String[] args) {
        C c = new Cylinder();
       c.volume();


    }
}
