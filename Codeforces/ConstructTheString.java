/*https://codeforces.com/problemset/problem/1335/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.PriorityQueue;

public class ConstructTheString
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		String[] tokens;
		int n, a, b, i;
		StringBuffer result = new StringBuffer("");
		while (tests-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			n = Integer.parseInt(tokens[0]);
			a = Integer.parseInt(tokens[1]);
			b = Integer.parseInt(tokens[2]);
			result = new StringBuffer("");
			for (i = 0; i < n; ++i)
			{
				result.append((char)(97+(i%b)));
			}
			System.out.println(result.toString());
		}
	}
}