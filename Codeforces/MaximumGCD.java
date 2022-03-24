/*https://codeforces.com/problemset/problem/1370/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MaximumGCD
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] ranges = new int[n];
		for (int i = 0; i < n; ++i)
			ranges[i] = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n; ++i)
		{
			if (ranges[i] == 1) System.out.println("1");
			else if (ranges[i]%2 == 0) System.out.println(ranges[i]/2);
			else System.out.println((ranges[i]-1)/2);
		}
	}
}