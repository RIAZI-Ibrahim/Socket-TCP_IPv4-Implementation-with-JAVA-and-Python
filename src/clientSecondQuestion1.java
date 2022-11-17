import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class clientSecondQuestion1 {


    private Socket socket;
    private Scanner scanner;
    private clientSecondQuestion1( int serverPort) throws Exception {
        this.socket = new Socket(InetAddress.getLocalHost(),serverPort);
        this.scanner = new Scanner(System.in);
    }
    private void start() throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in)) ;
        String line;
        System.out.println(InetAddress.getLocalHost().getHostName());
        while ((line = stdin.readLine()) != null) {
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            out.println(line + " [sent From Client 1] ");
            out.flush();
        }
    }

    public static void main(String[] args) throws Exception {
        clientSecondQuestion1 client = new clientSecondQuestion1(1234);

        System.out.println("\r\nConnected to Server: " + client.socket.getInetAddress());
        client.start();
    }
}
