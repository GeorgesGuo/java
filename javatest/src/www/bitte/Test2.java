package www.bitte;
/*利用接口做参数，写个计算器，能完成加减乘除运算。
        （1）定义一个接口Compute含有一个方法int computer(int n, int m)。
        （2）设计四个类分别实现此接口，完成加减乘除运算。
        （3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。
        （4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。
*/
interface ICompute{
    int compute(int n,int m);//default权限（啥也不写），只要在同一个源文件中，都可以访问

}
class UseCompute{
    private int n;
    private int m;
    public void UseCom(ICompute com,int one,int two){
        this.n=one;
        this.m=two;
        com.compute(n,m);
    }
}

class Add implements ICompute{
    private int n;
    private int m;
    private int ret;
    public int compute(int n,int m) {
        this.n = n;
        this.m = m;
        this.ret = n + m;
        System.out.println("n+m is " + ret);
        return ret;
    }

}
class Subtract implements ICompute{
    private int n;	private int m;
    private int ret;
    public int compute(int n,int m) {
        this.n = n;
        this.m = m;
        this.ret = n - m;
        System.out.println("n-m is " + ret);
        return ret;
    }

}
class Multiply implements ICompute{
    private int n;
    private int m;
    private int ret;
    public int compute(int n,int m) {
        this.n = n;
        this.m = m;
        this.ret = n * m;
        System.out.println("n*m is " + ret);
        return ret;
    }


}
class Divide implements ICompute{
    private int n;
    private int m;
    private int ret;
    public int compute(int n,int m){
        this.n=n;
        this.m=m;
        this.ret=n/m;
        System.out.println("n/m is "+ret);
        return ret;
    }
}
public class Test2 {
    public static void main(String []args){
        UseCompute fun=new UseCompute();
        fun.UseCom(new Add(),8,3);
        fun.UseCom(new Subtract(),8,3);
        fun.UseCom(new Multiply(),8,3);
        fun.UseCom(new Divide(),8,3);
    }

}
