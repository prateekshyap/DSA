/*https://codeforces.com/problemset/problem/1343/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BalancedArray
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(bufferedReader.readLine());
		while (testcases-- > 0)
		{
			int n = Integer.parseInt(bufferedReader.readLine());
			if ((n/2)%2 != 0)
				System.out.println("NO");
			else
			{
				System.out.println("YES");
				int[] result = new int[n];
				int oddNumber = 1, evenNumber = 2, oddSum = 0, evenSum = 0;
				for (int i = 0, j = n/2; j < n; ++i, ++j)
				{
					result[i] = evenNumber; evenSum += evenNumber; evenNumber += 2;
					result[j] = oddNumber; oddSum += oddNumber; oddNumber += 2;
				}
				result[n-1] += (evenSum-oddSum);
				for (int i = 0; i < n; ++i)
					System.out.print(result[i]+" ");
				System.out.println();
			}
		}
	}
}