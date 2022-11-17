import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class serverTcp {


    public ServerSocket serverSocket;




    public serverTcp(int port ) throws IOException {
        this.serverSocket=new ServerSocket(port);
    }
    private void listen() throws Exception {
        String data = null;
        Socket client = this.serverSocket.accept();
        String clientAddress = client.getInetAddress().getHostAddress();
        System.out.println("\r\nNew connection from " + clientAddress);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
        while ( (data = in.readLine()) != null ) {
            System.out.println("\r\nMessage from " + clientAddress + ": " +" > "+  data);
        }
    }
    public InetAddress getSocketAddress() {
        return this.serverSocket.getInetAddress();
    }

    public int getPort() {
        return this.serverSocket.getLocalPort();
    }
    public static void main(String[] args) throws Exception {
        serverTcp app = new serverTcp(1234);
        System.out.println("\r\nRunning Server: " +
                " On Port=" + app.getPort());

        app.listen();
    }

//    public  void receive(int port ) throws IOException {
//        this. serverSocket = new ServerSocket(port);
//        socket = serverSocket.accept();
//        input = socket.getInputStream();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//        String line = reader.readLine();
//        System.out.println(line);
//    }
//
//    public static void main(String[] args) throws IOException {
//        serverTcp serverTcp = new serverTcp();
//        serverTcp.receive(1234);
//    }
}
