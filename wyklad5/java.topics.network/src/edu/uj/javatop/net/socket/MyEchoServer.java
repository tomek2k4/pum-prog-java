package edu.uj.javatop.net.socket;

import java.net.ServerSocket;
import java.net.Socket;

public class MyEchoServer implements Runnable {

    private final int portNumber;
    private volatile boolean stopFlag = false;

    public MyEchoServer(int port) {
        this.portNumber = port;
    }

    public synchronized void stop() {
        stopFlag = true;
        //brak polaczenia do socketu, ktore spowoduje wyjscie z metody accept()
    }

    @Override
    public void run() {
        stopFlag = false;
        try (ServerSocket listenerSocket = new ServerSocket(portNumber)) {
            while (true) {
                Socket connection = listenerSocket.accept();
                System.out.println("Polaczenie zakceptowane.");
                if (!stopFlag) {
                    (new EchoConnectionThread(connection)).start();
                    System.out.println("Uruchomione watek obslugi polaczenia.");
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
