import java.util.Comparator;

public class SeatComparator implements Comparator<States> {
    @Override
    public int compare(States x, States y) {
        if (x.pv < y.pv) {
            return -1;
        }
        if (x.pv > y.pv) {
            return 1;
        }
        return 0;
    }
}