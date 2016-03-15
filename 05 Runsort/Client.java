import edu.princeton.cs.algs4.*;

public class Client 
{
	public static void main(String[] args)
	{
		String[] a = StdIn.readAllStrings();
		sort(a);
		StdOut.println("Is sorted: " + isSorted(a));
		show(a);
	}

	public static void sort(Comparable[] a)
	{
		Runsort.sort(a);
	}


	public static boolean isSorted(Comparable[] a)
	{
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}

	public static void show(Comparable[] a)
	{
		for (int i = 0; i < a.length; i ++) StdOut.print(a[i] + " ");
		StdOut.println();
	}

	@SuppressWarnings("unchecked")
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}


}