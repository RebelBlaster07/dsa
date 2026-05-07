package asign8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class WSclient {
    public static void main(String[] args) throws Exception {

        // Connect to server
        Socket socket = new Socket("localhost", 5000);

        // Send data to server
        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        // Receive data from server
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        // Send request
        out.println("Hello Server");

        // Receive response
        String response = in.readLine();

        System.out.println("Server Response: " + response);

        // Close connection
        socket.close();
    }
}
