package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
private final int PORT = 8189;
private final String IP_ADDRESS="localhost";
private Socket socket;
private DataOutputStream out;
private DataInputStream in;
private Scanner sc;

    public static void main(String[] args) {
        new Client().run();
    }

    private void run() {
        try{
            socket = new Socket(IP_ADDRESS,PORT);
            in=new DataInputStream(socket.getInputStream());
            out=new DataOutputStream(socket.getOutputStream());
            sc=new Scanner(System.in);
            System.out.println("Вы подключились к серверу");
            Thread clientThread=new Thread(()->{
                while (true){
                    serverMsg(sc.nextLine());
                }
            });
        clientThread.setDaemon(true);
            clientThread.start();
            while (true){
                String text = in.readUTF();
                if(text.equals("/end")){
                    break;
                }
                System.out.println("Сервер: "+text);
            }
            System.out.println("Сервер завершил работу");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            serverMsg("/end");
            try {
                in.close();
                out.close();
                sc.close();
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    private void serverMsg(String nextLine) {
        try {
            out.writeUTF(nextLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
