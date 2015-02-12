package edu.uj.javatop.net.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientExample {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (Socket client = new Socket("localhost", 8010)) {
           
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            
            for (int i = 1; i <=100; i++) {
                output.println("echo: " + i);
                System.out.println(input.readLine());
            }
            
            output.println("quit");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
