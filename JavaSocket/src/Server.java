/**
 * Created by lenovo on 2016/9/17.
 */

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    ServerSocket server;
    Socket socket;

    public Server()
    {
        try{
            server = new ServerSocket(3333);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                server.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void run()
    {
        while (true){
            try{
                socket = server.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                sleep(1000);

            }catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        new Server();
    }
}
