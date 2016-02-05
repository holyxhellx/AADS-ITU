import edu.princeton.cs.algs4.*;

public class UFW {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
        // Changed from QuickUnion
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            //StdOut.println(p + " " + q);
        }
        if (uf.connected(1, 0)) StdOut.println("TRUE");
            else StdOut.println("FALSE");
        //StdOut.println(uf.count() + " components");
    }

}