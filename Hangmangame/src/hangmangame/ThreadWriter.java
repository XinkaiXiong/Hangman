/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.io.*;
import java.net.*;

public class ThreadWriter extends Thread {

    Socket socket;

    public ThreadWriter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufout = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line;
            while ((line = bufr.readLine()) != null) {
                if ("QUIT".equals(line)) {
                    break;
                }
                bufout.write(line);
                bufout.newLine();
                bufout.flush();
            }
            socket.close();
            bufr.close();

        } catch (Exception e) {

        }
    }
}
