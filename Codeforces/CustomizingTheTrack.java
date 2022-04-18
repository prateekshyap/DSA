/*https://codeforces.com/problemset/problem/1543/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CustomizingTheTrack
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int n, i;
		long sum;
		String[] tokens;
		while (tests-- > 0)
		{
			n = Integer.parseInt(reader.readLine());
			tokens = reader.readLine().trim().split(" +");
			sum = 0;
			for (i = 0; i < n; ++i)
				sum += Long.parseLong(tokens[i]);
			sum -= (sum/n)*n;
			System.out.println(sum*(n-sum));
		}
	}
}