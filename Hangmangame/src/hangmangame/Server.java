/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.net.*;

public class Server {

    public static void main(String[] args) {
        try {//服务端在10001端口监听客户端请求的TCP连接
            ServerSocket server = new ServerSocket(10001);
            {
                Socket client = null;
                boolean f = true;
                while (f) {
                    //等待客户端的连接，如果没有获取连接
                    client = server.accept();
                    String ip = client.getInetAddress().getHostAddress();
                    System.out.println(ip + "......connected");
                    //为每个客户端连接开启一个线程
                    new Thread(new ServerThread(client)).start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
