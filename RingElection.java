import java.util.*;

public class RingElection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] process = new int[n];

        System.out.println("Enter process IDs:");
        for (int i = 0; i < n; i++) {
            process[i] = sc.nextInt();
        }

        System.out.print("Enter initiator index (0 to " + (n - 1) + "): ");
        int initiator = sc.nextInt();

        ArrayList<Integer> electionList = new ArrayList<>();

        System.out.println("\nElection started by P" + process[initiator]);

        int current = initiator;

        // circulate message
        do {
            System.out.println("P" + process[current] + " passes message");

            electionList.add(process[current]);

            current = (current + 1) % n;

        } while (current != initiator);

        // find leader
        int leader = Collections.max(electionList);

        System.out.println("\nProcesses participated: " + electionList);
        System.out.println("New Coordinator is: P" + leader);

        sc.close();
    }
}
