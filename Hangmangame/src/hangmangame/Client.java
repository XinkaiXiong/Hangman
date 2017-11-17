/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.net.*;

class Client {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("192.168.1.107", 10001);

        new ThreadWriter(socket).start();
        new ThreadReader(socket).start();
    }
}
