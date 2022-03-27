/*https://codeforces.com/problemset/problem/1367/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EvenArray
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(bufferedReader.readLine());
		int n, i, oddCount, evenCount, result = -1;
		String[] tokens;
		int[] arr;
		while (testcases-- > 0)
		{
			result = -1;
			n = Integer.parseInt(bufferedReader.readLine());
			arr = new int[n];
			tokens = bufferedReader.readLine().trim().split(" +");
			for (i = 0; i < n; ++i) arr[i] = Integer.parseInt(tokens[i]);
			oddCount = evenCount = 0;
			for (i = 0; i < n; ++i) if (arr[i]%2 == 0) ++evenCount; else ++oddCount;
			if (evenCount == oddCount || (n%2 == 1 && evenCount == oddCount+1))
			{
				result = 0;
				for (i = 0; i < n; i += 2) if (arr[i]%2 != 0) ++result;
			}
			if (n == 1 && arr[0]%2 == 1) System.out.println("-1");
			else System.out.println(result);
		}
	}
}