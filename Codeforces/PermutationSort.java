/*https://codeforces.com/problemset/problem/1525/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class PermutationSort
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int n, i, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		String[] tokens;
		int[] arr;
		boolean isSorted = true;
		while (tests-- > 0)
		{
			max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
			n = Integer.parseInt(reader.readLine());
			tokens = reader.readLine().trim().split(" +");
			arr = new int[n];
			isSorted = true;
			for (i = 0; i < n; ++i)
			{
				arr[i] = Integer.parseInt(tokens[i]);
				if (arr[i] > max) max = arr[i];
				if (arr[i] < min) min = arr[i];
				if (i != 0 && arr[i] < arr[i-1]) isSorted = false;
			}
			if (arr[0] == max && arr[n-1] == min) System.out.println("3");
			else if (!isSorted && (arr[0] == min || arr[n-1] == max)) System.out.println("1");
			else if (!isSorted) System.out.println("2");
			else System.out.println("0");
		}
	}
}