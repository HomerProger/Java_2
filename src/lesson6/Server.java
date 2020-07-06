package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private final int PORT=8189;
     ServerSocket server;
    Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
       new Server().run();

    }
    void run(){
        try {
            server=new ServerSocket(PORT);
            System.out.println("Сервер включен!");

            socket=server.accept();
            System.out.println("К серверу подключился клиент!");

            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());

            Thread serverThread = new Thread(()->{
                while (true){
                    clientMsg(sc.nextLine());
                }
            });
            serverThread.setDaemon(true);
            serverThread.start();
            while (true){
                String text=in.readUTF();
                if(text.equals("/end")){
                    break;
                }
                System.out.println("Клиент: "+text);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
                server.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("Сервер выключен!");
    }

    private void clientMsg(String text) {
        try {
            out.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
