package edu.uj.javatop.net.socket;

public class SocketTest {

    public static void main(String[] args) {
        MyEchoServer s = new MyEchoServer(8010);
        System.out.println("Serwer startuje. ");
        s.run();
    }

}
