package single;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SingleThreadServer {
    public static void main(String[] args) throws Exception{
        //1·建立基站
        ServerSocket server = new ServerSocket(6666);
        //2·等待客户端连接
        System.out.println("等待客户端连接。。。");
        Socket socket =server.accept();
        //3·建立连接后，进行数据输入输出
        PrintStream printStream = new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("hello i am Server~");
        Scanner scanner = new Scanner(socket.getInputStream());
        if (scanner.hasNext()){
            System.out.println("客户端发来的信息为："+scanner.nextLine());

        }
        //4·关闭流
        scanner.close();
        printStream.close();
        server.close();

    }
}
