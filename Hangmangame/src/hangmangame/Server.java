/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.net.*;

public class Server {

    public static void main(String[] args) {
        try {//the server listens to the TCP connection which is requested by the client on port 10001
            ServerSocket server = new ServerSocket(10001);
            {
                Socket client = null;
                boolean f = true;
                while (f) {
                    //waiting for client's connection
                    client = server.accept();
                    String ip = client.getInetAddress().getHostAddress();
                    System.out.println(ip + "......connected");
                    //create a new thread for each client
                    new Thread(new ServerThread(client)).start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
