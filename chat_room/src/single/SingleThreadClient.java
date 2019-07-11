package single;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadClient {
    public static void main(String[] args) throws Exception{
        //1·建立连接
        Socket socket = new Socket("127.0.0.1",6666);
        //2·进行数据的输入输出
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true,"UTF-8");
        //从键盘获取输入
        Scanner in = new Scanner(System.in);
        String str = "";
        System.out.println("请输入向服务器发送的信息");
        if(in.hasNext()){
            str = in.nextLine();
        }

        printStream.println(str);
        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("从服务器发来的消息为："+scanner.nextLine());
        }
        //3·关闭流
        printStream.close();
        scanner.close();
        socket.close();
    }
}
