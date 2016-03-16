import java.util.Comparator;
import edu.princeton.cs.algs4.*;
import java.util.PriorityQueue;

public class CongressAsger {

	public static void main(String[] args) {
        //Create a string of array for each line in the file.
		String[] lines = new In(args[0]).readAll().split("\\n");

		int totalStates = Integer.parseInt(lines[0]);
		int seats = Integer.parseInt(lines[1]);

		PriorityQueue<StateAsger> priority = new PriorityQueue<StateAsger>();

		//Create the number of states
		for (int i = 2 ; i < lines.length; i++) {
			//Start from line 3;
			priority.add(new StateAsger(lines[i], Integer.parseInt(lines[i+1])));
            i++;
		}

		//All states get atleast one seat
		seats = seats - totalStates;

		//Organize the remaining seats
        for (int i = seats ; i > 0 ; i--) {
			StateAsger current = priority.poll();
			current.increaseSeat();
			seats--;
            priority.add(current);
		}

		for (int i = priority.size() ; i > 0 ; i--) {
			StateAsger current = priority.poll();
			StdOut.println(current.getName()+" "+current.getSeat());
		}
	}
}
