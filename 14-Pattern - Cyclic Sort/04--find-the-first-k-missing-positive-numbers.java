// Java code for
// the above approach
import java.io.*;
import java.util.HashMap;

class GFG
{

	// Program to print first k
	// missing number
	static void printmissingk(int arr[], int n, int k)
	{
		// Creating a hashmap
		HashMap<Integer, Integer> d = new HashMap<>();

		// Iterate over array
		for (int i = 0; i < n; i++)
			d.put(arr[i], arr[i]);

		int cnt = 1;
		int fl = 0;

		// Iterate to find missing
		// element
		for (int i = 0; i < (n + k); i++) {
			if (!d.containsKey(cnt)) {
				fl += 1;
				System.out.print(cnt + " ");
				if (fl == k)
					break;
			}
			cnt += 1;
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		int arr[] = { 1, 4, 3 };
		int n = arr.length;
		int k = 3;
		printmissingk(arr, n, k);
	}
}

// This code is contributed by subhammahato348.
