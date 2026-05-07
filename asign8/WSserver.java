package asign8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WSserver {
    public static void main(String[] args) throws Exception {

        // Create server on port 5000
        ServerSocket server = new ServerSocket(5000);

        System.out.println("Server started...");
        System.out.println("Waiting for client...");

        // Accept client connection
        Socket socket = server.accept();

        System.out.println("Client connected!");

        // Read message from client
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        // Send message to client
        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        String clientMessage = in.readLine();

        System.out.println("Client says: " + clientMessage);

        // Web service response
        out.println("Hello Client, your request is processed!");

        // Close connections
        socket.close();
        server.close();
    }
}
