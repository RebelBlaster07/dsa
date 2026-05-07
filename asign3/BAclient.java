package asign3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class BAclient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        // Send client time
        long clientTime = System.currentTimeMillis();
        System.out.println("Client Time: " + clientTime);

        out.println(clientTime);

        // Receive synchronized time
        long syncTime = Long.parseLong(in.readLine());

        System.out.println("Synchronized Time: " + syncTime);

        socket.close();
    }
}
