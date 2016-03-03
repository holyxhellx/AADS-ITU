import edu.princeton.cs.algs4.*;
import java.lang.Math.*;

public class Congress {

    public static void main(String[] args) {
        StdOut.println("=====");

        int numberOfStates = Integer.parseInt(StdIn.readLine());
        int numberOfSeats = Integer.parseInt(StdIn.readLine()) - numberOfStates;

        MaxPQ<States> pq = new MaxPQ<States>(numberOfStates, new SeatComparator());
        while (StdIn.hasNextLine()) {
            String stateName = StdIn.readLine();
            int statePopulation = Integer.parseInt(StdIn.readLine());
            int priorityValue = (int) (statePopulation / (Math.sqrt(2 * 1)));
            pq.insert(new States(stateName, 1, statePopulation, priorityValue));
        }

        while (numberOfSeats > 0) {
            States head = pq.delMax();
            int newSeats = head.seatsReceived + 1;
            int priorityValue = (int) (head.numberOfTotalResidents / (Math.sqrt(newSeats * (newSeats + 1))));
            pq.insert(new States(head.name, newSeats, head.numberOfTotalResidents, priorityValue));
            numberOfSeats--;
        }

        for (States element : pq) {
            StdOut.println(element.name + " " + element.seatsReceived);
        }

        StdOut.println("=====");
    }
}