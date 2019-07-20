package multi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiThreadServer {
    private static Map<String,Socket> clientLists = new ConcurrentHashMap<>();

    //专门用来处理每个客户端的输入输出请求
    private static class ExecuteClientRequest implements Runnable{
        public ExecuteClientRequest(Socket client) {
            this.client = client;
        }

        private Socket client;
        @Override
        public void run() {
            //获取用户输入流。读取用户发来的信息
            try {
                Scanner in = new Scanner(client.getInputStream());
                String strFormClient = " ";
                while (true){
                    System.out.println("请输入要向服务器发送的信息。。。");
                    String strFromClient ="";
                    if(in.hasNext()){
                        strFromClient = in.nextLine();
                        //windows 下消除用户输入自带 \r
                        // 将\r替换为" "
                        Pattern pattern = Pattern.compile("\r");
                        Matcher matcher = pattern.matcher(strFromClient);
                        strFromClient = matcher.replaceAll("");
                    }
                    //注册流程
                    if(strFromClient.startsWith("userName")){
                        String userName = strFromClient.split("\\:")[1];
                        userRegister(userName,client);
                    }
                    //群聊信息
                    if(strFromClient.startsWith("G")){
                        String groupMsg = strFromClient.split("\\:")[1];
                        groupChat(groupMsg);


                    }
                    //私聊流程
                    if(strFromClient.startsWith("p")){
                        String userName =strFromClient.split("\\:")[1].split("\\-")[0];
                        String privateMsg = strFromClient.split("\\:")[1].split("\\-")[0];
                        privateChat(userName,privateMsg);

                    }
                    //用户退出
                    if(strFromClient.contains("byebye")){
                        String userName = strFromClient.split("\\:")[0];
                        userOffline(userName);
                        break;

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //注册方法
        //socket 用户名对应的Socket
        private  void userRegister(String userName,Socket socket){
            clientLists.put(userName,socket);
            System.out.println("用户"+userName+"上线了！");
            System.out.println("当前聊天室人数为："+clientLists.size());
            try {
                PrintStream out = new PrintStream(socket.getOutputStream(),true,"UTF-8");
                out.println("注册成功");
                out.println("当前聊天室人数为："+clientLists.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //群聊方法
        //便利Map，想每个客户端输出一边
        private void  groupChat(String groupMsg ){
            Set<Map.Entry<String ,Socket>>clientEntry = clientLists.entrySet();
            Iterator<Map.Entry<String, Socket>>
                    iterable =  clientEntry.iterator();
            while (iterable.hasNext()){
                Map.Entry<String,Socket>client = iterable.next();
                //拿到客户端输出聊输出客户端信息
                try {
                    PrintStream out = new PrintStream(client.getValue().getOutputStream(),true,"UTF-8");
                    out.println("群聊信息为："+groupMsg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        private void privateChat(String userName,String privateMsg){
            //取出userName对应的Socket
            Socket client = clientLists.get(userName);
            //获取输出流
            try {
                PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
                out.println("私聊信息为："+privateMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void userOffline(String userName){
            //删除Map中用户实体
            clientLists.remove(userName);
            System.out.println("用户"+userName+"已下线！");
            System.out.println("当前聊天室人数为："+clientLists.size());

        }
    }

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(6666);
        //使用线程池处理多个客户端连接
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        System.out.println("等待客户端连接");
        for (int i = 0; i <20 ; i++) {
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接，端口号为："+client.getPort());
            executorService.submit(new ExecuteClientRequest(client));

        }
        //关闭线程池与服务端
        executorService.shutdown();
        serverSocket.close();
    }
}
