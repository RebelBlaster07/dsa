import java.util.Scanner;

public class TokenRing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int token = 0; // initially token with process 0

        while (true) {

            System.out.println("\nToken currently with Process P" + token);
            System.out.print("Process P" + token + " wants to enter CS? (y/n/exit): ");

            String choice = sc.next();

            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("Execution terminated.");
                break;
            }

            if (choice.equalsIgnoreCase("y")) {
                System.out.println("P" + token + " ENTERING Critical Section");

                try {
                    Thread.sleep(1000); // simulate work
                } catch (InterruptedException e) {
                }

                System.out.println("P" + token + " EXITING Critical Section");
            }

            // Pass token to next process
            token = (token + 1) % n;
        }

        sc.close();
    }
}
