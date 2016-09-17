/**
 * Created by lenovo on 2016/9/17.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    public ServerThread(Socket socket)
    {
        this.socket = socket;
    }

    public void run(){
        try{

            printWriter = new PrintWriter(this.socket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            String line = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder(line);
            String output = stringBuilder.reverse().toString();
            printWriter.print(output);
            printWriter.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
