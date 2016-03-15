import edu.princeton.cs.algs4.*;

public class Runsort {
  
    private Runsort() { } // This class should not be instantiated.

    // stably merge a[lo..mid] with a[mid+1..hi] using aux[lo..hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];  // this copying is unneccessary
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];

        outerloop:
        while(true)
        {
	        StdOut.println("new round");
	        show(a);

	        int i = 0;
	      
	        while(i<N-1) {
	        	
	        	// first run
	            int lo = i;
	        	while(! less(a[i+1],a[i])) i++; 
	        	int m = i;

	        	// second run
	        	i++;
	        	while(i<N-1 && !less(a[i+1],a[i])) i++;
	        	int hi = i;

	        	merge(a, aux, lo, m, hi); // merge runs
	        	
	        	i++;
				if(lo == 0 && hi == N-1) break outerloop; // if sorted break
	        }
        }
       
        
        

        /*
        for (int n = 1; n < N; n = n+n) {
            for (int i = 0; i < N-n; i += n+n) {
                int lo = i;
                int m  = i+n-1;
                int hi = Math.min(i+n+n-1, N-1);
                merge(a, aux, lo, m, hi);
            }
        }*/
    }

  	/***********************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
   
    // is v < w ?
    @SuppressWarnings("unchecked")
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

	private static void show(Comparable[] a)
	{
		for (int i = 0; i < a.length; i ++) StdOut.print(a[i] + " ");
		StdOut.println();
	}

	private static boolean isSorted(Comparable[] a)
	{
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}

	public static void main(String[] args)
	{
		String[] a = StdIn.readAllStrings();
		sort(a);
		StdOut.println("Is sorted: " + isSorted(a));
		show(a);
	}

}
