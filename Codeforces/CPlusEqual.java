/*https://codeforces.com/problemset/problem/1368/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CPlusEqual
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int a, b, n, count = 0;
		String[] tokens;
		while (tests-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			a = Integer.parseInt(tokens[0]);
			b = Integer.parseInt(tokens[1]);
			n = Integer.parseInt(tokens[2]);
			count = 0;
			while (a <= n & b <= n)
			{
				if (a < b) a += b;
				else b += a;
				++count;
			}
			System.out.println(count);
		}
	}
}