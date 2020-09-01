import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientOne {

    public static void main() {
        try {
            Scanner sc = new Scanner(System.in);
            int clientOne = 9090;
            Socket connection = new Socket("192.168.0.0", clientOne);
            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
            DataInputStream inputStream = new DataInputStream(connection.getInputStream());

            while (true) {
                String data = inputStream.readUTF();
                System.out.println("Received :" + data);
                String sendMessage = sc.nextLine();
                outputStream.writeUTF(sendMessage);
                if(sendMessage.equalsIgnoreCase("exit now")){
                    System.out.println("Close the connection");
                    connection.close();
                    System.out.println("Closed connection");
                    break;
                }
            }
            sc.close();
            inputStream.close();
            outputStream.close();
        }catch (IOException e){
            System.out.println("Client one Exception : "+e.getMessage());
        }finally {

        }

    }
   private int lCountOne = 0;

    public ClientOne() throws IOException {
    }

    public void increment(){
       System.out.println("Printing Sum for Logical Clock one ");
       lCountOne++;
   }

   public void decrement(){
       System.out.println("Printing Decrement for Logical Clock");
       lCountOne++;
   }

   public void triggerEvent(){
       System.out.println("Increment the logical Counter if an event is getting triggered");
       lCountOne++;
   }

}
