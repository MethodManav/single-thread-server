
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server {

    @SuppressWarnings("CallToPrintStackTrace")
    public void run() {
        int port = 8000;
        try {
            ServerSocket socket = new ServerSocket(port);
            socket.setSoTimeout(10000);
            while (true) {
                System.out.println("Server is listening to port " + port);
                Socket acceptedConnection = socket.accept();
                System.out.println("Connection Accepted from client " + acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello From Server");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
