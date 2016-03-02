import java.util.PriorityQueue;
import edu.princeton.cs.algs4.*;
import java.lang.Math.*;

public class Congress {

    public static void main(String[] args) {
        StdOut.println("=====");

        int numberOfStates = StdIn.readInt(); //2
        int numberOfSeats = StdIn.readInt() - numberOfStates; //4-2

        MaxPQ<States> pq = new MaxPQ<States>(numberOfStates, new SeatComparator());
        for (int i = 1; i <= numberOfStates; i++) {
            String tmpName = StdIn.readString();
            int tmpPopulation = StdIn.readInt();
            int pv = (int) ((tmpPopulation) / (Math.sqrt(((1 + 1) * 1)))); 
            //StdOut.println(tmpName + " " + pv);

            // starts from base 0 and hence the 2nd's seat pv is: n = 1 for the curret seat, and n+1 for the next potential seat
            pq.insert(new States(tmpName, 1, tmpPopulation, pv));
        } 

        for (int i = numberOfSeats; i > 0; i--) {
            States head = pq.delMax();
            int currentSeatsReceived = head.seatsReceived;
            int pv = (int) ((head.numberOfTotalResidents) / (Math.sqrt(((currentSeatsReceived + 1) * currentSeatsReceived))));

            States newHead = new States(head.name, (head.seatsReceived + 1), pv);
            //StdOut.println(newHead.name + " " + newHead.pv);

            pq.insert(newHead);
        }

        for (States element : pq) {
            StdOut.println(element.name + " " + element.seatsReceived);
        }

        StdOut.println("=====");
    }
}

/* small-4-in is wrong. if you use the actual formula you get 2 and 2

*/