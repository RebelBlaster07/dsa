import java.util.Scanner;

public class BullyElection {

    static int n;
    static boolean[] active;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        active = new boolean[n];

        // Initially all processes are active
        for (int i = 0; i < n; i++) {
            active[i] = true;
        }

        System.out.print("Enter process that will fail (0 to " + (n - 1) + "): ");
        int fail = sc.nextInt();
        active[fail] = false;

        System.out.println("Process P" + fail + " has failed.");

        System.out.print("Enter process to initiate election: ");
        int initiator = sc.nextInt();

        election(initiator);

        sc.close();
    }

    // Election function
    static void election(int initiator) {

        System.out.println("\nElection started by P" + initiator);

        boolean higherAlive = false;

        // Send messages to higher processes
        for (int i = initiator + 1; i < n; i++) {
            if (active[i]) {
                System.out.println("P" + initiator + " sends ELECTION to P" + i);
                higherAlive = true;
            }
        }

        // If no higher process is alive
        if (!higherAlive) {
            System.out.println("P" + initiator + " becomes the Coordinator");
            return;
        }

        // Highest active process becomes coordinator
        for (int i = n - 1; i >= 0; i--) {
            if (active[i]) {
                System.out.println("P" + i + " becomes the Coordinator");
                break;
            }
        }
    }
}
