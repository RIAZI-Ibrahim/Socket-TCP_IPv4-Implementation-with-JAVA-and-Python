import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientTcpFirstQuestion {


    InetAddress host;
    Socket socket;
    //    c.connect(localhost, 1234);
    public  void sendMessage ( String localhost, int server,String text ) throws IOException {

    host =InetAddress.getLocalHost();
    socket = new Socket(localhost, server);
//    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)) ;
//    String line;
//    System.out.println("Say something!");
//    while ((line = stdin.readLine()) != null) {
//        System.out.println("You entered: " + line);
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        os.writeObject((text+"\n"));
    }

    public static void main(String[] args) throws IOException {
        ClientTcpFirstQuestion clientTcpFirstQuestion =new ClientTcpFirstQuestion();
        clientTcpFirstQuestion.sendMessage("localhost",1234,"hi");
    }


}

