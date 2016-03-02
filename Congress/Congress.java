import java.util.PriorityQueue;
import edu.princeton.cs.algs4.*;

public class Congress {

    public static final int constant = 500000;

    public static void main(String[] args) {
        StdOut.println("=====");

        int numberOfStates = StdIn.readInt(); //2
        int numberOfSeats = StdIn.readInt() - numberOfStates; //4-2

        MaxPQ<States> pq = new MaxPQ<States>(numberOfStates, new SeatComparator());
        for (int i = 0; i < numberOfStates; i++) {
            String tmpName = StdIn.readString();
            StdOut.println(i);
            int tmpPopulation = StdIn.readInt();
            pq.insert(new States(tmpPopulation, tmpName, 1));
        } 

        for (int i = numberOfSeats; i > 0; i--) {
            StdOut.println(i);
            States head = null;
            head = pq.delMax();
            States newHead = null;
            int newSeatsReceived = head.seatsReceived;
            int newNumberOfRemainingResidents = head.numberOfRemainingResidents - constant;
            if (newNumberOfRemainingResidents <= 0) { 
                newHead = new States(0, head.name, newSeatsReceived);
            } else {
                newHead = new States(newNumberOfRemainingResidents, head.name, (newSeatsReceived + 1));
            }
            pq.insert(newHead);
        }

        for (States element : pq) {
            StdOut.println(element.name + " " + element.seatsReceived);
        }

        StdOut.println("=====");
    }
}