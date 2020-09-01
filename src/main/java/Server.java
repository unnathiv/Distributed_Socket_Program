import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;

public class Server {

    public static void main(String args[]) {
        try{
            int clientPort = 9090;
            ServerSocket server = new ServerSocket(clientPort);
            Socket connection = server.accept();
            DataInputStream inputStream = new DataInputStream(connection.getInputStream());
        }
        catch (IOException e){
            System.out.println("Catch exceptiom"+e.getMessage());
        }
    }
}
