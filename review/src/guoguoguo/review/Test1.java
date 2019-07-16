package guoguoguo.review;

import static java.lang.System.out;

class Cat{
    private String name ="";
    public Cat(String name){
        this.name = name;
    }


    public String Shout(){
        return "我的名字是"+name+" 喵~";

    }

}
public class Test1 {
    public static void main(String[] args) {
        Cat cat = new Cat("小米");
        out.println(cat.Shout());
    }

}
