/*https://codeforces.com/problemset/problem/1401/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DistanceAndAxis
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		String[] tokens;
		int a, k, b;
		while (tests-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			a = Integer.parseInt(tokens[0]);
			k = Integer.parseInt(tokens[1]);
			if (a <= k) System.out.println(k-a);
			else System.out.println((a%2)^(k%2));
		}
	}
}