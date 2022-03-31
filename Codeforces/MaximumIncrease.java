/*https://codeforces.com/problemset/problem/702/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MaximumIncrease
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		String[] tokens = reader.readLine().trim().split(" +");
		for (int i = 0; i < n; ++i) arr[i] = Integer.parseInt(tokens[i]);
		int maxCount = 1;
		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) dp[i] = 1;
		for (int i = 1; i < n; ++i)
		{
			if (arr[i-1] < arr[i]) dp[i] = dp[i-1]+1;
			maxCount = Math.max(maxCount,dp[i]);
		}
		System.out.println(maxCount);
	}
}