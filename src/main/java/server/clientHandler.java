package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class clientHandler implements Runnable {
    Socket clientsocket;
    DataInputStream dis;
    DataOutputStream dos;
    BufferedReader bufferedReader;
    BufferedWriter bufferedWriter;
    String data;

    clientHandler(Socket clientsocket){
        this.clientsocket = clientsocket;
        try {
            this.dis = new DataInputStream(clientsocket.getInputStream());
            this.dos = new DataOutputStream(clientsocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true){
            readMsg();

        }
    }

    public void readMsg(){
        try {
            data = dis.readUTF();
            if(data!=null){
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
