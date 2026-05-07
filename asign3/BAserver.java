package asign3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BAserver {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started... Waiting for clients");

        List<Long> clientTimes = new ArrayList<>();
        List<Socket> clients = new ArrayList<>();

        // Accept 3 clients
        for (int i = 0; i < 3; i++) {
            Socket socket = serverSocket.accept();
            clients.add(socket);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            long clientTime = Long.parseLong(in.readLine());
            clientTimes.add(clientTime);

            System.out.println("Received time: " + clientTime);
        }

        // Server time
        long serverTime = System.currentTimeMillis();

        long sum = serverTime;
        for (long t : clientTimes) {
            sum += t;
        }

        long avgTime = sum / (clientTimes.size() + 1);

        System.out.println("Average Time: " + avgTime);

        // Send synchronized time to all clients
        for (Socket s : clients) {
            PrintWriter out = new PrintWriter(
                    s.getOutputStream(), true);
            out.println(avgTime);
            s.close();
        }

        serverSocket.close();
    }
}
