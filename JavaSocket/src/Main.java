/**
 * Created by lenovo on 2016/9/17.
 */
public class Main {
    public static void main(String[] args)throws InterruptedException
    {
        Thread serverTthread = new Thread(new Runnable(){
            public void run(){
                new Server();
            }
        });
       // System.out.print("Hello");
        serverTthread.start();
        Thread.sleep(1000);
//        Thread clientThread = new Thread(new Runnable(){
//            public void run(){
//                new Client();
//            }
//        });
//        clientThread.start();
    }
}
