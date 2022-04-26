/*https://codeforces.com/problemset/problem/1324/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class YetAnotherTetrisProblem
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int n, i, refBlock;
		int[] arr;
		String[] tokens;
		boolean result = true;
		while (tests-- > 0)
		{
			result = true;
			n = Integer.parseInt(reader.readLine());
			tokens = reader.readLine().trim().split(" +");
			arr = new int[n];
			for (i = 0; i < n; ++i)
				arr[i] = Integer.parseInt(tokens[i]);
			refBlock = arr[0];
			for (i = 1; i < n; ++i)
				if ((refBlock-arr[i])%2 != 0)
					result = false;
			System.out.println(result?"YES":"NO");
		}
	}
}