package edu.uj.javatop.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoConnectionThread extends Thread {

    private Socket connectionSocket;

    public EchoConnectionThread(Socket s) {
        super();
        connectionSocket = s;
        setDaemon(true);
    }

    @Override
    public void run() {
        if (connectionSocket == null) {
            return;
        }

        try {
            InputStream input = connectionSocket.getInputStream();
            OutputStream output = connectionSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    input));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(output));

            String line;
            int counter = 1;
            out.print(counter + "--> ");
            out.flush();
            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase("quit")) {
                    break;
                } else if (!line.trim().isEmpty()) {
                    out.println("[" + counter + "]>>" + line + "<<");
                    counter++;
                }
                out.print(counter + "--> ");
                out.flush();
            }
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connectionSocket = null;
        }
    }
}
